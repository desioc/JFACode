package test;

import excs.AnnotationException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
import metadata.Bean;
import metadata.Short;
import metadata.Specification;

public class InteractiveChecker {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String string = "";      
        System.out.println("Type the name of a java file present in the "
                + "current folder and type enter, or write \"end\" "
                + "to end the program");
        while (!(string = scanner.next()).equals("end")) {
            System.out.println("You typed " + string.toUpperCase() + "!");
            try {
                checkClass(string);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Program terminated!");
    }

    private static void checkClass(String string) throws Exception {
        Class objectClass = Class.forName(string);
        checkShort(string, objectClass);
        checkSpecification(string, objectClass);
        checkBean(string, objectClass);
    }

    private static void checkShort(String string, Class objectClass) throws AnnotationException {
        try {
            System.out.println("Start checking @Short annotation for " + string);
            Annotation shortAnnotation = objectClass.getAnnotation(Short.class);
            if (shortAnnotation != null) {
                Method[] methods = objectClass.getDeclaredMethods();
                final int methodsNumber = methods.length;
                if (methodsNumber > 3) {
                    throw new AnnotationException("There are " + methodsNumber
                            + " methods in the class " + string);
                }
                System.out.println("Class " + string + " valid!\nmethods list:");
                for (Method method : methods) {
                    System.out.println(method);
                }
            } else {
                System.out.println("This class is not annotated with @Short");
            }
        } finally {
            System.out.println("End of Short annotation check for " + string);
        }
    }

    private static void checkSpecification(String string, Class objectClass) throws AnnotationException {
        try {
            System.out.println("Start check @Specification annotation for "
                    + string);
            Specification specification = (Specification) objectClass.getAnnotation(Specification.class);
            if (specification != null) {
                int variablesNumberFromSpecification = specification.value();
                Field[] fields = objectClass.getDeclaredFields();
                final int variablesNumber = fields.length;
                if (variablesNumber != variablesNumberFromSpecification) {
                    throw new AnnotationException("There are " + variablesNumber
                            + " variables in the class " + string
                            + " but they should be " + variablesNumberFromSpecification);
                }
                System.out.println("Class " + string + " valid!\nvariables list:");
                for (Field field : fields) {
                    System.out.println(field);
                }
            } else {
                System.out.println("This class is not annotated with @Specification");
            }
        } finally {
            System.out.println("End check @Specification annotation for " + string);
        }
    }

    private static void checkBean(String string, Class objectClass) throws AnnotationException, NoSuchMethodException {
        try {
            System.out.println("Start check @Bean annotation per "
                    + string);
            Bean bean = (Bean) objectClass.getAnnotation(Bean.class);
            if (bean != null) {
                checkVariablesNumber(bean, objectClass, string);
                checkMethodsNumber(bean, objectClass, string);
                checkNoArgumentsConstructor(objectClass, string);
                checkEncapsulation(objectClass, string);
            } else {
                System.out.println("This class is not annotated with @Bean");
            }
        } finally {
            System.out.println("End check @Bean annotation for " + string);
        }
    }

    private static void checkVariablesNumber(Bean bean, Class objectClass, String string) throws AnnotationException {
        int variablesMinNumber = bean.variablesMinNumber();
        Field[] fields = objectClass.getDeclaredFields();
        final int variablesNumber = fields.length;
        if (variablesNumber < variablesMinNumber) {
            throw new AnnotationException("There are " + variablesNumber
                    + " variables in the class " + string
                    + " but they should be at least " + variablesMinNumber);
        }
        System.out.println("Class " + string + ": variables number ok!\nvariables list:");
        for (Field field : fields) {
            System.out.println(field);
        }
    }

    private static void checkMethodsNumber(Bean bean, Class objectClass, String string) throws AnnotationException, NoSuchMethodException {
        int methodsMaxNumber = bean.methodsMaxNumber();
        Method[] methods = objectClass.getDeclaredMethods();
        final int methodsNumber = methods.length;
        if (methodsNumber > methodsMaxNumber) {
            throw new AnnotationException("There are " + methodsNumber
                    + " methods in the class " + string
                    + " but thau should be a maximum of " + methodsMaxNumber);
        }
        System.out.println("Class " + string + ": methods number ok!\nmethods list:");
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    private static void checkNoArgumentsConstructor(Class objectClass, String string) throws AnnotationException, NoSuchMethodException {
        Constructor constructor = objectClass.getConstructor();
        if (constructor == null) {
            throw new AnnotationException(
                    "No constructor without parameters!");
        }
        System.out.println("Class " + string
                + " no-arguments constructor present!:");
        System.out.println(constructor);
    }

    private static void checkEncapsulation(Class objectClass, String string) throws AnnotationException, NoSuchMethodException {
        Field[] fields = objectClass.getDeclaredFields();
        for (Field field : fields) {
            final String variableName = field.getName();
            final Class<?> type = field.getType();
            final Method setMethod = objectClass.getDeclaredMethod("set" + capitalize(variableName), type);
            final Method getMethod = objectClass.getDeclaredMethod("get" + capitalize(variableName));
            if (setMethod == null || getMethod == null || 
                    !getMethod.getReturnType().equals(type)) {
                throw new AnnotationException("Variable " + variableName +
                        " not properly encapsulated in the class" + string);
            }
        }
        System.out.println("Class " + string + ": encapsulation ok!");

    }

    private static String capitalize(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }
}
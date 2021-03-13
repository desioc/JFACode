import java.lang.reflect.*;
public class ClassReflectionTest {
    public static void main(String args[]) throws Exception {
        String className = "java.lang.Object";
        if (args.length > 0) {
            className = args[0];
        }
        Class<?> objectClass = Class.forName(className);
        Method[] methods = objectClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            String name = methods[i].getName();
            Parameter[] classParameters =
            methods[i].getParameters();
            String stringClassParameters = "";
            int length = classParameters.length;
            for (int j = 0; j < length; ++j) {
                stringClassParameters +=
                classParameters[j].getType().getName() + " " +
                classParameters[j].getName();
                // add a comma to separate the parameters
                // but not for the last parameter
                if (j != (length-1)) {
                    stringClassParameters += ", ";
                }
            }
            String methodReturnType =
            methods[i].getReturnType().getName();
            String methodString = methodReturnType + " " +
            name + " (" + stringClassParameters + ")";
            System.out.println(methodString);
        }
    }
}
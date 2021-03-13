import java.lang.reflect.*;

public class Exercise13S {
    public static void main(String args[]) throws Exception {
        Class<ClassWithPrivateMembers> classWithPrivateMembers = ClassWithPrivateMembers.class;
        ClassWithPrivateMembers object = classWithPrivateMembers.getDeclaredConstructor().newInstance();
        /* Field privateVariable = classWithPrivateMembers.getField("privateVariable");
        privateVariable.setAccessible(true);
        privateVariable.set(object, "Private variable hacked!"); 
        System.out.println(privateVariable.get(object));*/
        Method privateMethod = classWithPrivateMembers.getMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(object);
    }
}
import java.lang.reflect.*;
public class ClassIntrospection {
    public static void printImplementedInterfaces(Object object) {
        Class<?> objectClass = object.getClass();
        Class<?> [] interfaces = objectClass.getInterfaces();
        System.out.println("Implemented interfaces:");
        for (Class<?> classInterface : interfaces) {
            System.out.println(classInterface.getName());
        }
    }
    public static void main(String args[]) {
        Thinker interestingPerson = InterestingPersonFactory.getInterestingPerson();
        printImplementedInterfaces(interestingPerson);
        Reader reader = (Reader)interestingPerson;
        reader.read(new Book("The Master and Margarita", "Michail Bulgakov"));
//        var veryInterestingPerson = InterestingPersonFactory.getInterestingPerson();
//        veryInterestingPerson.read(new Book("The Master and Margarita", "Michail Bulgakov"));
//        veryInterestingPerson.program("Java");
//        Reader reader = InterestingPersonFactory.getInterestingPerson();
//        Programmer programmer = InterestingPersonFactory.getInterestingPerson();
        var veryInterestingPerson = InterestingPersonFactory.getVeryInterestingPerson();
//        veryInterestingPerson.read(new Book("The Master and Margarita", "Michail Bulgakov"));
        veryInterestingPerson.program("Java");
    }
}
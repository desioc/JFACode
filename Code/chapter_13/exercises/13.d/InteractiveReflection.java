import java.lang.reflect.Method;
import java.util.Scanner;

public class InteractiveReflection {

    public static void main(String args[]) { 
        Scanner scanner = new Scanner(System.in);
        String string = "";
        System.out.println("Type the name of a class in the " + 
            "current folder and type enter, or write \"end\" to end the program");
        while (!(string = scanner.next()).equals("end")) {
            System.out.println("You typed " + string.toUpperCase() + "!");
            try {
                printMethods(string);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Program terminated!");
    }

    private static void printMethods(String string) throws ClassNotFoundException {
        Class objectClass = Class.forName(string);
        Method[] methods = objectClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

    }
}
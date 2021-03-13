import java.util.Scanner;

public class InteractiveApp {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String string = "";
        System.out.println("Type something then press enter, or type \"end\" to end the program");
        while(!(string = scanner.next()).equals("end")) {
            System.out.println("You typed " + string.toUpperCase() + "!");
        }
        System.out.println("Program ended!");
    }
}
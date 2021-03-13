
import java.util.Scanner;

public class InteractiveCompiler {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String string = "";
        System.out.println("Type the name of a source Java file in the " + 
            "current folder and type enter, or write \"end\" to end the program");
        while (!(string = scanner.next()).equals("end")) {
            System.out.println("You typed " + string.toUpperCase() + "!");
            try {
                buildClass(string);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Program terminated!");
    }

    private static void buildClass(String string) throws Exception {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("javac " + string);
        final int exitValue = process.waitFor();
        System.out.println(exitValue == 0 ? string + " compiled!" : "Cannot compile " + string);
    }
}
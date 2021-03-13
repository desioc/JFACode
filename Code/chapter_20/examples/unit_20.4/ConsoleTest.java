import java.io.*;

public class ConsoleTest {
    public static void main(String args[]) {
        Console console = System.console();
        if (console == null) {
            System.out.println("Please launch this class from command line");
            return;
        }
        System.out.println("Insert password");
        char[] passwd;
        if ((passwd = console.readPassword())  != null) {
            System.out.print("Password = ");
            System.out.print(passwd);
        }
    }
}
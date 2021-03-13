import java.util.Scanner;

public class Moderator {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String string = "";
        System.out.println("Type something then press enter, or type \"end\" to end the program");
        while (!(string = scanner.next()).equals("end")) {
            string = moderateString(string);
            System.out.println("You typed " + string.toUpperCase() + "!");
        }
        System.out.println("Program ended!");
    }

    private static String moderateString(String string) {
        switch (string) {
            case "gosh":
            case "golly":
            case "hilarious":
            case "jocund":
                string = "CENSORED!";
                break;
            default:
                break;
        }
        return string;
    }
}
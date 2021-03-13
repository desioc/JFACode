import java.util.Scanner;

public class Exercise4Q {
    
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the number of days passe from the end of your last holidays");
        int days = scanner.nextInt();
        System.out.println("You typed " + days + " days!");
        int ore = days*24;
        int minutes = ore*60;
        System.out.println("So " + minutes + " minutes are just passed from your last holidays!");
    }
}
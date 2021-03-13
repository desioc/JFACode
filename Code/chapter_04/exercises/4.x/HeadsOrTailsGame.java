import java.util.*;

public class HeadsOrTailsGame {
    public static void main(String args[]) {
        System.out.println("Heads or Tails?");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if ("heads".equals(input)) {
            System.out.println("Ok, tossing the coin...");
            HeadsOrTails headsOrTails = new HeadsOrTails();
            String result = headsOrTails.getHeadsOrTails();
            System.out.print("It's " +  result + "...");
            System.out.println("Heads".equalsIgnoreCase(result)? "you win!" : "you lose!");
        } else if ("tails".equals(input)) {
            System.out.println("Ok, tossing the coin...");
            HeadsOrTails headsOrTails = new HeadsOrTails();
            String result = headsOrTails.getHeadsOrTails();
            System.out.print("It's " +  result + "...");
            System.out.println("Tails".equalsIgnoreCase(result)? "you win!" : "you lose!");
        } else {
            System.out.println("I'm sorry, you can only write heads or tails, try again...");
            System.out.println("Program terminated... bye!");
        }
    }
}
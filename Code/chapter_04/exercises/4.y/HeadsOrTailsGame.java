import java.util.*;

public class HeadsOrTailsGame {
    public static void main(String args[]) {
        System.out.println("Let's play heads or tails, how many attempts you want to do?");
        Scanner scanner = new Scanner(System.in);
        String numberOfAttemptsString = scanner.nextLine();
        int numberOfAttempts = Integer.parseInt(numberOfAttemptsString);
        int counter = 1;
        var numberOfWinningAttempts = 0;
        var numberOfLosingAttempts = 0;
        String message = "";
        System.out.println("You have chosen to do "+ numberOfAttempts +" attempts...let's begin!");
        while (counter <= numberOfAttempts) {
            System.out.println("Attempt number " + counter);
            System.out.println("Heads or tails?");
            String choice = scanner.nextLine();
            if ("heads".equalsIgnoreCase(choice)) {
                System.out.println("Ok, tossing a coin...");
                HeadsOrTails headsOrTails = new HeadsOrTails();
                String result = headsOrTails.getHeadsOrTails();
                counter++;
                System.out.print("It's "+ result + "...");
                if ("heads".equalsIgnoreCase(result)) {
                        message = "you win!";
                        numberOfWinningAttempts++;
                } else {
                        message = "you lose!";
                        numberOfLosingAttempts++;
                }
            } else if ("tails".equalsIgnoreCase(choice)) {
                System.out.println("Ok, tossing a coin...");
                HeadsOrTails headsOrTails = new HeadsOrTails();
                String result = headsOrTails.getHeadsOrTails();
                counter++;
                System.out.print("It's "+ result + "...");
                 if ("tails".equalsIgnoreCase(result)) {
                        message = "you win!";
                        numberOfWinningAttempts++;
                } else {
                        message = "you lose!";
                        numberOfLosingAttempts++;
                }
            } else {
                message = "I'm sorry, you can only write heads or tails, try again...";
            }
            System.out.println(message);
        }
        message = "You win " + numberOfWinningAttempts + " times, and lost " + numberOfLosingAttempts + " times, so...";
        if (numberOfWinningAttempts > numberOfLosingAttempts) {
            message += "you win the game! Congratulations!";
        } else if (numberOfWinningAttempts < numberOfLosingAttempts) {
            message += "you lose the game! Ah ah!";
        } else {
            message += "you draw the game! Try again!";
        }
        System.out.println(message);
    }
}
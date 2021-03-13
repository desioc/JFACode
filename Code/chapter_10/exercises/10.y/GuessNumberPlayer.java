import java.util.Scanner;

public class GuessNumberPlayer extends Player {
    private Scanner scanner;
    private int numberToGuess;
    private int attemptsNumber;

    public GuessNumberPlayer (int id, String name, Scanner scanner, int numberToGuess) {
        super(id, name);
        this.scanner = scanner;
        this.numberToGuess = numberToGuess;
    }

    public void incrementAttemptsNumber() {
        attemptsNumber++;
    }

    public int getAttemptsNumber() {
        return attemptsNumber;
    }
    
    @Override
    public boolean play() {
        if (scanner.hasNextInt()) {
            incrementAttemptsNumber();
            int number = scanner.nextInt();
            if (number < numberToGuess) {
                System.out.println("Too low, try again");
            } else if (number > numberToGuess) {
                System.out.println("Too high, try again");
            } else {
                return true;
            }
        } else {
            System.out.println("Invalid input '"+ scanner.next () +"'. You can only enter integer numbers, please try again");
            play();
        }
        return false;
    }
}
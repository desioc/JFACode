import java.util.Scanner;
import java.util.Random;

public class GuessNumberGame implements Game {
    private static final int MAX_NUMBER = 100;
    private Scanner scanner;
    private int attemptsNumber;
    private int numberToGuess;

    public GuessNumberGame () {
        init();
        start();
        play();
        end();
    }

    @Override
    public void init() {
        scanner = new Scanner(System.in);
        numberToGuess = GuessNumber.generateRandomNumber(MAX_NUMBER);
    }
    
    @Override
    public void start() {
        System.out.println("I'm thinking of a number between 1 and "+ MAX_NUMBER +", guess what!");
    }
    
    @Override
    public void play() {
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                attemptsNumber++;
                int number = scanner.nextInt();
                if (number < numberToGuess) {
            System.out.println("Too low, try again");
        } else if (number > numberToGuess) {
            System.out.println("Too high, try again");
                } else {
                    return;
                }
            } else {
                System.out.println("Invalid input '"+ scanner.next () +"'. You can only enter integer numbers, please try again");
            }
        }
    }
    
    @Override
    public void end() {
        System.out.println("Yes! You guessed it after "+ attemptsNumber +" attempts");
    }

    public static void main(String args[]) {
        new GuessNumberGame();
    }
}
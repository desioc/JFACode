import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class GuessNumberGame extends MultiPlayerGame implements Configurator {
    private static final int MAX_NUMBER = 100;
    private static int counter;
    private Player currentPlayer;
    private Scanner scanner;
    private int numberToGuess;

/* public GuessNumberGame () {
        init();
        start();
        play();
        end();
    }*/

    @Override
    public void init() {
        super.init();
        scanner = new Scanner(System.in);
        numberToGuess = GuessNumber.generateRandomNumber(MAX_NUMBER);
    }

    @Override
    public void start() {
        config();
        System.out.println("I'm thinking of a number between 1 and "+ MAX_NUMBER +", guess what!");
    }

    @Override
    public void config() {
        System.out.println("Enter player name "+ (++counter) + (getPlayers().isEmpty() ?"":" Or 'i' to start playing"));
        String text = scanner.next();
        if (!getPlayers().isEmpty() && text.equals("i")) {
            currentPlayer = getPlayers().get(0);
            System.out.println(currentPlayer + " is your turn");
            return;
        }
        addPlayer(new GuessNumberPlayer (counter, text, scanner, numberToGuess));
        config();
    }

    @Override
    public void play() {
        while (scanner.hasNext()) {
            boolean result = currentPlayer.play();
            if (result) {
                return;
            }
            currentPlayer = getCurrentPlayer();
            System.out.println(currentPlayer + " is your turn");
        }
    }

    private Player getCurrentPlayer() {
        int nextPlayerIndex = currentPlayer.getId();
        var players = getPlayers();
        if (nextPlayerIndex == players.size()) {
            nextPlayerIndex = 0;
        }
        return players.get(nextPlayerIndex);
    }

    @Override
    public void end() {
        System.out.println("Yes "+ currentPlayer.getName() +"! You guessed it after "+ ((GuessNumberPlayer)currentPlayer).getAttemptsNumber() +" attempts");
    }

    public static void main(String args[]) {
        new GuessNumberGame();
    }
}
import java.util.Random;

public class RockPaperScissors {
    public void play(int id) {
        Symbol playerSymbol = getSymbol(id);
        Symbol computerSymbol = getComputerSymbol();
        System.out.println(playerSymbol +" VS "+ computerSymbol);
        String result = calculateWinner(playerSymbol, computerSymbol);
        System.out.println(result);
    }

    private String calculateWinner(Symbol playerSymbol, Symbol computerSymbol) {
        Rules rules = new Rules();
        int result = rules.compare(playerSymbol, computerSymbol);
        if (result > 0) {
            return playerSymbol +" Wins!\nYou win!";
        } else if (result < 0) {
            return computerSymbol +" Wins!\nYou loose!";
        } else {
            return "Draw!";
        }
    }

    private Symbol getSymbol(int id) {
        Symbol[] symbols = Symbol.values();
        Symbol computerSymbol = symbols[id];
        return computerSymbol;
    }

    private Symbol getComputerSymbol() {
        Random random = new Random();
        return getSymbol(random.nextInt(3));
    }
}
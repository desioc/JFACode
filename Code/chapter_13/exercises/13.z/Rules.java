import java.util.Comparator;

public class Rules implements Comparator<Symbol> {
    @Override
    public int compare(Symbol symbol1, Symbol symbol2) {
        int result = 0;
        switch (symbol1) {
            case PAPER: {
                if (symbol2 == Symbol.ROCK) {
                    result = 1;
                } else if (symbol2 == Symbol.SCISSORS) {
                    result = -1;
                }
            }
            break;
            case ROCK: {
                if (symbol2 == Symbol.SCISSORS) {
                    result = 1;
                } else if (symbol2 == Symbol.PAPER) {
                    result = -1;
                }
            }
            break;
            case SCISSORS: {
                if (symbol2 == Symbol.PAPER) {
                    result = 1;
                } else if (symbol2 == Symbol.ROCK) {
                    result = -1;
                }
            }
            break;
            default: {
                result = 0;
            }
            break;

        }
        return result;
    }
}
public class NullCoinException extends RuntimeException {
    public NullCoinException() {
        super("The passed coin was null");
    }    
}
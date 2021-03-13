//@SuppressWarnings("serial")
public class BookingException extends Exception {
    public BookingException() {
        // The Exception constructor invoked initialize 
        // the private variable message
        super("Problem with the booking");
    }
    @Override
    public String toString() {
        return getMessage() + ": sold-out!";
    }
}
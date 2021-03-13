package phonebook.exceptions;

public class EmptyNameException extends Exception {
    private static final long serialVersionUID = 8290498479156525745L;

    public EmptyNameException() {
        super("The contact name cannot be empty!");
    }
}
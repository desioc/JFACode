package phonebook.exceptions;

import java.io.IOException;

public class InvalidCommandException extends IOException {
    
    private static final long serialVersionUID = 6742493040156525789L;
    
    public InvalidCommandException(String command){
        super("Invalid command:" + command);
    }
}
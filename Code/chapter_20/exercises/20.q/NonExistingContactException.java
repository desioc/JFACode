package phonebook.exceptions;

import java.io.IOException;

public class NonExistingContactException extends IOException {
    
    private static final long serialVersionUID = 8942402240056525663L;
    
    public NonExistingContactException(String message){
        super(message);
    }
}
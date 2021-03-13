package phonebook.exceptions;
import java.io.IOException;

public class DuplicateContactException extends IOException {
    
    private static final long serialVersionUID = 8942402240056525662L;
    
    public DuplicateContactException(String message){
        super(message);
    }
}
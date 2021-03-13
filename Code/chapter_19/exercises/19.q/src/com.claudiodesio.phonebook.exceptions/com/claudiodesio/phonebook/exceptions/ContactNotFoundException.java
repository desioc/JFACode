package com.claudiodesio.phonebook.exceptions;
import java.io.IOException;

public class ContactNotFoundException extends IOException {
    
    private static final long serialVersionUID = 8942402240056525663L;
    
    public ContactNotFoundException (String message){
        super(message);
    }
}
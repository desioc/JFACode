package com.claudiodesio.phonebook.exceptions;

import java.io.IOException;

public class NonExistentContactException extends IOException {
    
    private static final long serialVersionUID = 8942402240056525663L;
    
    public NonExistentContactException(String message){
        super(message);
    }
}
package com.claudiodesio.observatory.metadata;

public enum Status {
    WAITING("\"I'm waiting...\""), OBSERVATION("\"It's my turn... how wonderful!\""), DONE("\"I'm done.\"");
    
    private String message;

    private Status(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
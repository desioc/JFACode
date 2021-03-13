package com.claudiodesio.excs;

public class DuplicateException extends RuntimeException {

    public DuplicateException(Object duplicateElement) {
        super("Unable to add item \""
                + duplicateElement + "\" because already present");
    }
}
package com.polykek.library.exception;

public class BookTypeNotFoundException extends RuntimeException {
    public BookTypeNotFoundException(String msg) {
        super(msg);
    }
}

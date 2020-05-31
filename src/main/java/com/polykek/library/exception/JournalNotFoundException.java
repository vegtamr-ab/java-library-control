package com.polykek.library.exception;

public class JournalNotFoundException extends RuntimeException {
    public JournalNotFoundException(String msg) {
        super(msg);
    }
}

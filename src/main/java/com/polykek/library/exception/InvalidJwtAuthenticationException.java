package com.polykek.library.exception;

public class InvalidJwtAuthenticationException extends RuntimeException {
    public InvalidJwtAuthenticationException(String msg) {
        super(msg);
    }
}

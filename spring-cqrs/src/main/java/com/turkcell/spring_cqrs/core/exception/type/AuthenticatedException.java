package com.turkcell.spring_cqrs.core.exception.type;

public class AuthenticatedException extends RuntimeException {
    public AuthenticatedException(String message) {
        super(message);
    }
}
package com.turkcell.spring_cqrs.core.exception.type;

public class AuthorizationException extends RuntimeException {
    public AuthorizationException(String message) {
        super(message);
    }
}
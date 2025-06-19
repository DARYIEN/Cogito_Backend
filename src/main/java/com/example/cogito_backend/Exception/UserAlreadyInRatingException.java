package com.example.cogito_backend.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyInRatingException extends RuntimeException {
    public UserAlreadyInRatingException(String message) {
        super(message);
    }
}
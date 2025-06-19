package com.example.cogito_backend.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserRatingNotFoundException extends RuntimeException {
    public UserRatingNotFoundException(String message) {
        super(message);
    }
}

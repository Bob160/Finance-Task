package com.example.clientcontractor.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<Object> handleUserNotFound(UserNotFoundException ex) {
        ApiError apiError = new ApiError();
        apiError.setStatus(HttpStatus.UNAUTHORIZED);
        apiError.setMessage(ex.getMessage());
        apiError.setDebugMessage(ex.getDebugMessage());

        return  new ResponseEntity<>(apiError, HttpStatus.UNAUTHORIZED);
    }
}

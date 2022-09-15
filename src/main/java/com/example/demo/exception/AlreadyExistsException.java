package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.CONFLICT;

@ControllerAdvice
public class AlreadyExistsException {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){

        HttpStatus conflictStatus = CONFLICT;

        ApiException apiException = new ApiException(
                e.getMessage(),
                conflictStatus
        );
        return new ResponseEntity<>(apiException, conflictStatus);
    }

}

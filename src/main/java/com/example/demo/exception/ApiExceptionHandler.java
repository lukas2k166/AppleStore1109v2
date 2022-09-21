package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ApiExceptionHandler {


    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException e){

        HttpStatus notFoundRequest = NOT_FOUND;

        ApiException apiException = new ApiException(
                e.getMessage(),
                notFoundRequest
        );

        return new ResponseEntity<>(apiException, notFoundRequest);
    }

    @ExceptionHandler(value = {AlreadyExistsException.class})
    public ResponseEntity<Object> handleAlreadyExistsException(AlreadyExistsException e){

        HttpStatus conflictRequest = CONFLICT;

        ApiException apiException = new ApiException(
                e.getMessage(),
                conflictRequest
        );
        return new ResponseEntity<>(apiException, conflictRequest);
    }


}

package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public record ApiException (String errorMessage, HttpStatus httpStatus){
}

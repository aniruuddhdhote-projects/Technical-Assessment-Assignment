package com.example.productapi.exception;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntime(RuntimeException ex){
        return new ResponseEntity<>(
                new ErrorResponse(ex.getMessage(),400),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex){

        String msg = ex.getBindingResult().getFieldError().getDefaultMessage();

        return new ResponseEntity<>(
                new ErrorResponse(msg,400),
                HttpStatus.BAD_REQUEST
        );
    }
}
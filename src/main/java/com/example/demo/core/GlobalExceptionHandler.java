package com.example.demo.core;

import com.example.demo.model.BlogException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity indibuExceptionHandler(BlogException exception) {
        return new ResponseEntity<>(exception.getMessage(), exception.getHttpStatus());
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity defaultExceptionHandler(Exception exception) {
        return new ResponseEntity<>(exception.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

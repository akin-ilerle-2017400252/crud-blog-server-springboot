package com.example.demo.model;

import org.springframework.http.HttpStatus;


public class BlogException extends RuntimeException {

    HttpStatus httpStatus;

    public BlogException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public BlogException() {
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }


}

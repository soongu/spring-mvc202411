package com.spring.springmvc.chap6_2.exception;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}

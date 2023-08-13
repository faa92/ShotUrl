package com.example.url.exception;

public class BusinessException extends RuntimeException{
    public BusinessException(String massage) {
        super(massage);
    }
}

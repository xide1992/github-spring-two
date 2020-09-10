package com.yy.exercisespring.common.exceptions;

public class ValidationFailureException extends RuntimeException {

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ValidationFailureException() {
        super();
    }

    public ValidationFailureException(String message) {
        this.message = message;
    }
}

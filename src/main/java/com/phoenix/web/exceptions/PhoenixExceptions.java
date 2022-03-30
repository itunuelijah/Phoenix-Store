package com.phoenix.web.exceptions;

public class PhoenixExceptions extends RuntimeException{
    public PhoenixExceptions() {
    }

    public PhoenixExceptions(String message) {
        super(message);
    }

    public PhoenixExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public PhoenixExceptions(Throwable cause) {
        super(cause);
    }
}
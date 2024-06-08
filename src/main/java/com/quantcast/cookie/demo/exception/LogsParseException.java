package com.quantcast.cookie.demo.exception;

public class LogsParseException extends RuntimeException {
    public LogsParseException(String message) {
        super(message);
    }

    public LogsParseException(String message, Throwable cause) {
        super(message, cause);
    }
}

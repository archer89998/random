package org.random.automation.rest;

public class RestException extends RuntimeException {

    RestException(String message, String... args) {
        super(String.format(message, args));
    }
}

package org.random.automation.util;

class PropertiesControllerException extends RuntimeException {

    PropertiesControllerException(String message, Throwable e, String... args) {
        super(String.format(message, args), e);
    }
}

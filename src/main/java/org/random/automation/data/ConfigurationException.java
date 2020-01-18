package org.random.automation.data;

public class ConfigurationException extends RuntimeException {

    ConfigurationException(String message, String... args) {
        super(String.format(message, args));
    }
}

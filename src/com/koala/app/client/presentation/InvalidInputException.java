package com.koala.app.client.presentation;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 24.11.2016.
 */
public class InvalidInputException extends RuntimeException {

    public InvalidInputException () {

    }

    public InvalidInputException (String message) {
        super (message);
    }

    public InvalidInputException (Throwable cause) {
        super (cause);
    }

    public InvalidInputException (String message, Throwable cause) {
        super (message, cause);
    }
}

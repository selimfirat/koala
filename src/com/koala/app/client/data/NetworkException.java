package com.koala.app.client.data;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 24.11.2016.
 */
public class NetworkException extends RuntimeException {
    public NetworkException () {

    }

    public NetworkException (String message) {
        super (message);
    }

    public NetworkException (Throwable cause) {
        super (cause);
    }

    public NetworkException (String message, Throwable cause) {
        super (message, cause);
    }
}

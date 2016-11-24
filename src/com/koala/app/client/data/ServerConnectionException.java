package com.koala.app.client.data;

import com.koala.app.client.data.NetworkException;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 24.11.2016.
 */
public class ServerConnectionException extends NetworkException {

    public ServerConnectionException () {

    }

    public ServerConnectionException (String message) {
        super (message);
    }

    public ServerConnectionException (Throwable cause) {
        super (cause);
    }

    public ServerConnectionException (String message, Throwable cause) {
        super (message, cause);
    }
}

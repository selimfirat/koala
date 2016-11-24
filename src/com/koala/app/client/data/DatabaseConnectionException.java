package com.koala.app.client.data;

import com.koala.app.client.data.NetworkException;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 24.11.2016.
 */
public class DatabaseConnectionException extends NetworkException {

    public DatabaseConnectionException () {

    }

    public DatabaseConnectionException (String message) {
        super (message);
    }

    public DatabaseConnectionException (Throwable cause) {
        super (cause);
    }

    public DatabaseConnectionException (String message, Throwable cause) {
        super (message, cause);
    }

}

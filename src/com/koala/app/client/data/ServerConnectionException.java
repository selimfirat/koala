package com.koala.app.client.data;

import com.koala.app.client.data.NetworkException;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 24.11.2016.
 */
public class ServerConnectionException extends NetworkException {

    //default ServerConnectionException
    public ServerConnectionException () {

    }

    /*ServerConnectionException
     *@param message
     */
    public ServerConnectionException (String message) {
        super (message);
    }

    /*ServerConnectionException
     *@param cause
     */
    public ServerConnectionException (Throwable cause) {
        super (cause);
    }

    /*ServerConnectionException
     *@param message
     *@param cause
     */
    public ServerConnectionException (String message, Throwable cause) {
        super (message, cause);
    }
}

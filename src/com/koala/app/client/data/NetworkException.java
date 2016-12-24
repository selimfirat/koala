package com.koala.app.client.data;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 24.11.2016.
 */
public class NetworkException extends RuntimeException {
    public NetworkException () {

    }

    /*NetworkException exception
     *@param message
     */
    public NetworkException (String message) {
        super (message);
    }

    /*NetworkException exception
     *@param cause
     */
    public NetworkException (Throwable cause) {
        super (cause);
    }

    /*NetworkException exception
     *@param message
     *@param cause
     */
    public NetworkException (String message, Throwable cause) {
        super (message, cause);
    }
}

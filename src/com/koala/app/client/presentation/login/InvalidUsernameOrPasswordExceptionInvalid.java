package com.koala.app.client.presentation.login;

import com.koala.app.client.presentation.InvalidInputException;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 24.11.2016.
 */
public class InvalidUsernameOrPasswordExceptionInvalid extends InvalidInputException {

    public InvalidUsernameOrPasswordExceptionInvalid () {

    }

    public InvalidUsernameOrPasswordExceptionInvalid (String message) {
        super (message);
    }

    public InvalidUsernameOrPasswordExceptionInvalid (Throwable cause) {
        super (cause);
    }

    public InvalidUsernameOrPasswordExceptionInvalid (String message, Throwable cause) {
        super (message, cause);
    }
}

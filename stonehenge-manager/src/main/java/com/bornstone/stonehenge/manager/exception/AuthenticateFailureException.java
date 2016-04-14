package com.bornstone.stonehenge.manager.exception;

/**
 * Created by king on 15-5-17.
 */
public class AuthenticateFailureException extends ManagerException {
    public AuthenticateFailureException() {
        super();
    }

    public AuthenticateFailureException(String message) {
        super(message);
    }

    public AuthenticateFailureException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthenticateFailureException(Throwable cause) {
        super(cause);
    }
}

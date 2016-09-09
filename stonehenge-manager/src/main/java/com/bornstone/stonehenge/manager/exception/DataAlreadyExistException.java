package com.bornstone.stonehenge.manager.exception;

/**
 * Created by king on 16-9-9.
 */
public class DataAlreadyExistException extends ManagerException {
    public DataAlreadyExistException() {
        super();
    }

    public DataAlreadyExistException(String message) {
        super(message);
    }

    public DataAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataAlreadyExistException(Throwable cause) {
        super(cause);
    }
}

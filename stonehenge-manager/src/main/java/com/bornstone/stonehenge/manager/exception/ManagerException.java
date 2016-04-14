package com.bornstone.stonehenge.manager.exception;

/**
 * @author woodbird
 * @since 2012-10-21
 */
public class ManagerException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ManagerException() {
        super();
    }

    public ManagerException(String message) {
        super(message);
    }

    public ManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ManagerException(Throwable cause) {
        super(cause);
    }

}

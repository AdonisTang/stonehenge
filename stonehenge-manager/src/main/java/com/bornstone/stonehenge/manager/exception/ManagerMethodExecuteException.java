package com.bornstone.stonehenge.manager.exception;

/**
 * Created by King.Tang on 14-10-16.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public class ManagerMethodExecuteException extends RuntimeException {
    public ManagerMethodExecuteException() {
        super();
    }

    public ManagerMethodExecuteException(String s) {
        super(s);
    }

    public ManagerMethodExecuteException(String message, Throwable cause) {
        super(message, cause);
    }

    public ManagerMethodExecuteException(Throwable cause) {
        super(cause);
    }
}

package com.bornstone.stonehenge.manager.exception;

/**
 * Created by King.Tang on 14-10-27.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public class EntityValidateFailureException extends RuntimeException {
    public EntityValidateFailureException() {
        super();
    }

    public EntityValidateFailureException(String s) {
        super(s);
    }

    public EntityValidateFailureException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityValidateFailureException(Throwable cause) {
        super(cause);
    }
}

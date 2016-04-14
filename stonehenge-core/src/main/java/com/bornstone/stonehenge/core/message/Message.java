package com.bornstone.stonehenge.core.message;

/**
 * Created by King.Tang on 14-6-2.
 */
public class Message {
    private Status status;
    private String message;
    private Object data;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public enum Status {
        SUCCESS, FAILURE
    }
}

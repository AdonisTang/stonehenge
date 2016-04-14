package com.bornstone.stonehenge.core.notification.message;

import java.io.Serializable;

/**
 * Created by king on 15-5-14.
 */
public class Message implements Serializable {
    private String target;
    private String message;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

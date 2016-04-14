package com.bornstone.stonehenge.core.notification.message;

/**
 * Created by king on 15-5-14.
 */
public class EmailMessage extends Message {
    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

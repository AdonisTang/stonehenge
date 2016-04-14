package com.bornstone.stonehenge.core.notification.messagesender.email;

import com.bornstone.stonehenge.core.notification.message.EmailMessage;
import com.bornstone.stonehenge.core.notification.messagesender.IMessageSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * Created by king on 15-5-16.
 */
public interface IEmailMessageSender extends IMessageSender<EmailMessage> {
    void setMailSender(JavaMailSenderImpl mailSender);
}

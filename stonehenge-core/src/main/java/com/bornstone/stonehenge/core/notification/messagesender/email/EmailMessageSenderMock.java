package com.bornstone.stonehenge.core.notification.messagesender.email;

import com.bornstone.stonehenge.core.notification.message.EmailMessage;
import org.apache.log4j.Logger;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * Created by king on 15-5-14.
 */
public class EmailMessageSenderMock implements IEmailMessageSender {
    private static final Logger logger = Logger.getLogger(EmailMessageSenderMock.class);

    @Override
    public void send(EmailMessage message) {
        logger.info("======================");
        logger.info("message.subject:" + message.getSubject());
        logger.info("message.message:" + message.getMessage());
        logger.info("======================");
    }

    public void setMailSender(JavaMailSenderImpl mailSender) {

    }
}

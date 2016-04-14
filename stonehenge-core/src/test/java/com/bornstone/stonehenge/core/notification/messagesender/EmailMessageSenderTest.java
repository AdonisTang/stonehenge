package com.bornstone.stonehenge.core.notification.messagesender;

import com.bornstone.stonehenge.core.notification.message.EmailMessage;
import com.bornstone.stonehenge.core.notification.messagesender.email.EmailMessageSender;
import org.junit.Test;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * Created by king on 15-5-14.
 */
public class EmailMessageSenderTest {
    @Test
    public void test() {
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setTarget("249645546@qq.com");
        emailMessage.setSubject("testEmail");
        emailMessage.setMessage("<h1>Test</h1>");

        Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "false");
        props.put("mail.debug", "true");

        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.163.com");
        javaMailSender.setProtocol("smtp");
        javaMailSender.setPort(25);
        javaMailSender.setUsername("11111111@163.com");
        javaMailSender.setPassword("11111111");
        javaMailSender.setJavaMailProperties(props);

        EmailMessageSender sender = new EmailMessageSender();
        sender.setMailSender(javaMailSender);
        sender.send(emailMessage);
    }
}

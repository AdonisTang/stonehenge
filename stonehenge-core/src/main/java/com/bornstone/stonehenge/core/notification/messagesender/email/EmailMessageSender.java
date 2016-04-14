package com.bornstone.stonehenge.core.notification.messagesender.email;

import com.bornstone.stonehenge.core.notification.message.EmailMessage;
import org.apache.log4j.Logger;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by king on 15-5-14.
 */
public class EmailMessageSender implements IEmailMessageSender {
    private static final Logger logger = Logger.getLogger(EmailMessageSender.class);

    private JavaMailSenderImpl mailSender;

    @Override
    public void send(EmailMessage message) {
        if (mailSender == null) {
            logger.error("mailSender can not be null");
            return;
        }

        try {
            Session session = Session.getDefaultInstance(new Properties());
            MimeMessage mime = new MimeMessage(session);
            MimeMessageHelper helper = new MimeMessageHelper(mime, true, "utf-8");
            helper.setFrom(mailSender.getUsername());//发件人
            helper.setTo(InternetAddress.parse(message.getTarget()));//收件人
            //helper.setBcc("administrator@chinaptp.com");//暗送
            helper.setReplyTo(mailSender.getUsername());//回复到
            helper.setSubject(message.getSubject());//邮件主题
            helper.setText(message.getMessage(), true);//true表示设定html格式

            mailSender.send(mime);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public void setMailSender(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }
}

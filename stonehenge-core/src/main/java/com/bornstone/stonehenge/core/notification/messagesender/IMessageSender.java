package com.bornstone.stonehenge.core.notification.messagesender;

import com.bornstone.stonehenge.core.notification.message.Message;

/**
 * Created by king on 15-5-14.
 */
public interface IMessageSender<M extends Message> {
    void send(M message);
}

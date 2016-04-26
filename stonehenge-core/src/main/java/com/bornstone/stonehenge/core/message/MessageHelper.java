package com.bornstone.stonehenge.core.message;

import com.alibaba.fastjson.JSON;

/**
 * Created by King.Tang on 14-6-2.
 */
public class MessageHelper {
    public static Message buildSuccessMessage(String messageContent, Object data) {
        Message message = new Message();
        message.setStatus(Message.Status.SUCCESS);
        message.setMessage(messageContent);
        message.setData(data);
        return message;
    }

    public static Message buildSuccessMessage(Object data) {
        return buildSuccessMessage("", data);
    }

    public static Message buildSuccessMessage() {
        return buildSuccessMessage(null);
    }

    public static String buildSuccessMessageJson(String messageContent, Object data) {
        return JSON.toJSONString(buildSuccessMessage(messageContent, data));
    }

    public static String buildSuccessMessageJson(Object data) {
        return buildSuccessMessageJson("", data);
    }

    public static String buildSuccessMessageJson() {
        return buildSuccessMessageJson(null);
    }

    public static Message buildFailureMessage(String messageContent) {
        Message message = new Message();
        message.setStatus(Message.Status.FAILURE);
        message.setMessage(messageContent);
        message.setData(null);
        return message;
    }

    public static Message buildFailureMessage() {
        return buildFailureMessage("");
    }

    public static String buildFailureMessageJson(String messageContent) {
        return JSON.toJSONString(buildFailureMessage(messageContent));
    }

    public static String buildFailureMessageJson() {
        return buildFailureMessageJson("");
    }
}

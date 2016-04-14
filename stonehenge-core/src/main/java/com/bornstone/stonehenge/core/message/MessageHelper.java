package com.bornstone.stonehenge.core.message;

import com.google.gson.Gson;

/**
 * Created by King.Tang on 14-6-2.
 */
public class MessageHelper {
    public static String buildSuccessMessage(String messageContent, Object data) {
        Message message = new Message();
        message.setStatus(Message.Status.SUCCESS);
        message.setMessage(messageContent);
        message.setData(data);

        Gson gson = new Gson();
        return gson.toJson(message);
    }

    public static String buildSuccessMessage(Object data) {
        return buildSuccessMessage("", data);
    }

    public static String buildSuccessMessage() {
        return buildSuccessMessage(null);
    }

    public static String buildFailureMessage(String messageContent) {
        Message message = new Message();
        message.setStatus(Message.Status.FAILURE);
        message.setMessage(messageContent);
        message.setData(null);

        Gson gson = new Gson();
        return gson.toJson(message);
    }

    public static String buildFailureMessage() {
        return buildFailureMessage("");
    }
}

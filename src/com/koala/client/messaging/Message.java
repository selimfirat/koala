package com.koala.client.messaging;

import com.koala.client.roles.User;
import com.koala.client.utils.UID;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 10.11.2016.
 */
public class Message {

    private UID uid;
    private User from;
    private User to;
    private String message;

    public Message(UID uid, User from, User to, String message) {
        this.uid = uid;
        this.from = from;
        this.to = to;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public UID getUid() {
        return uid;
    }

    public void setUid(UID uid) {
        this.uid = uid;
    }
}

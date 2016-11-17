package com.koala.client.models.messaging;

import com.koala.client.models.roles.User;
import com.koala.client.utils.UID;

import java.util.Date;

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
    private Date date;
    private Message topLevelMessage;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Message getTopLevelMessage() {
        return topLevelMessage;
    }

    public void setTopLevelMessage(Message topLevelMessage) {
        this.topLevelMessage = topLevelMessage;
    }
}

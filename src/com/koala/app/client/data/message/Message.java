package com.koala.app.client.data.message;

import com.koala.app.client.data.user.UserEntity;

import java.util.Date;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 10.11.2016.
 */
public class Message {

    private UserEntity from;
    private UserEntity to;
    private String message;
    private Date date;
    private Message topLevelMessage;

    public Message(UserEntity from, UserEntity to, String message) {
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

    public UserEntity getTo() {
        return to;
    }

    public void setTo(UserEntity to) {
        this.to = to;
    }

    public UserEntity getFrom() {
        return from;
    }

    public void setFrom(UserEntity from) {
        this.from = from;
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

package com.koala.app.client.models.message;

import com.koala.app.client.models.user.User;
import org.jongo.marshall.jackson.oid.MongoId;

import java.util.Date;

/**
 * Created by mrsfy on 13-Dec-16.
 */
public class Message implements Comparable<Message> {

    @MongoId
    private String id;

    private User to;
    private User from;
    private String message;
    private Date date;

    public Message() {
    }

    public Message(User to, User from, String message, Date date) {
        this.to = to;
        this.from = from;
        this.message = message;
        this.date = date;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int compareTo(Message o) {
        return this.getDate().compareTo(o.getDate());
    }

    @Override
    public String toString(){
        return "[Message] ID: "+getId()+" TO: "+getTo()+" From: "+getFrom()+" Date: "+getDate()+" Context: "+getMessage();
    }
}
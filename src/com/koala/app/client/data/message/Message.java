package com.koala.app.client.data.message;

import com.koala.app.client.data.user.User;
import org.jongo.marshall.jackson.oid.MongoId;

import java.util.Date;

/**
 * Created by mrsfy on 13-Dec-16.
 */
public class Message {

    //variables
    @MongoId
    private String id;
    private User to;
    private User from;
    private String message;
    private Date date;

    /*message object with given parameters
     *@param to
     *@param from
     *@param message
     *@param date
     */
    public Message(User to, User from, String message, Date date) {
        this.to = to;
        this.from = from;
        this.message = message;
        this.date = date;
    }

    /*getID method to get id
     *returns id
     */
    public String getId() {

        return id;
    }

    /*setId method to set the id
     *@param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /*getTo method to get the user which receives the message
     *returns to
     */
    public User getTo() {
        return to;
    }

    /*setTo method to set the user that receives the message
     *@param to
     */
    public void setTo(User to) {
        this.to = to;
    }

    /*getFrom method to get the user which sends the message
     *returns from
     */
    public User getFrom() {
        return from;
    }

    /*setFrom method to set the user that sends the message
     *@param from
     */
    public void setFrom(User from) {
        this.from = from;
    }

    /*getMessage method to get the message between two user
     *returns message
     */
    public String getMessage() {
        return message;
    }

    /*setMessage method to set the content of the message
     *@param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /*getDate method to get the date of the message
     *returns date
     */
    public Date getDate() {
        return date;
    }

    /*setDate method to set the date of the message
     *@param date
     */
    public void setDate(Date date) {
        this.date = date;
    }
}

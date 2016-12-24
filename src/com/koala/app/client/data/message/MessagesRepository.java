package com.koala.app.client.data.message;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import rx.Observable;

import java.util.Date;

/**
 * Created by mrsfy on 13-Dec-16.
 */
public class MessagesRepository {

    //variables
    private static MessagesRepository _instance;

    private MongoCollection messages;

    private MessagesRepository() { }

    /*getInstance method to return repository if it exists, otherwise to create one
     *returns _instance
     */
    public static MessagesRepository getInstance() {

        if (_instance == null)
            _instance = new MessagesRepository();

        return _instance;
    }

    /*setJongo method to set messages in database
    */
    public void setJongo(Jongo jongo) {
        messages = jongo.getCollection("messages");
    }

    /*findAfter method to find the messages after a specific date
     *returns null
     */
    public Observable<Message> findAfter(Date date) {
        return null;
    }

    /*findBefore method to find the messages before a specific date
     *returns null
     */
    public Observable<Message> findBefore(Date date) {
        return null;
    }

    /*getMessagesOfCurrentUser method to get messages of a user
     *returns null
     */
    public Observable<Message> getMessagesOfCurrentUser() {
        return null;
    }

    /*save method to save messaging history
     *returns null
     */
    public Observable<Void> save(Message message) {
        return null;
    }



}

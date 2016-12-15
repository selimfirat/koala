package com.koala.app.client.data.message;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import rx.Observable;

import java.util.Date;

/**
 * Created by mrsfy on 13-Dec-16.
 */
public class MessagesRepository {

    private static MessagesRepository _instance;

    private MongoCollection messages;

    private MessagesRepository() { }

    public static MessagesRepository getInstance() {

        if (_instance == null)
            _instance = new MessagesRepository();

        return _instance;
    }

    public void setJongo(Jongo jongo) {
        messages = jongo.getCollection("messages");
    }

    public Observable<Message> findAfter(Date date) {
        return null;
    }

    public Observable<Message> findBefore(Date date) {
        return null;
    }

    public Observable<Message> getMessagesOfCurrentUser() {
        return null;
    }

    public Observable<Void> save(Message message) {
        return null;
    }



}

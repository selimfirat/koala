package com.koala.app.client.data.message;

import com.koala.app.client.data.user.Identity;
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

    public Observable<Message> getSentMessagesOfCurrentUser() {
        return Observable.from(messages.find("{sender: #}", Identity.getCurrentUser().getId()).as(Message.class));
    }

    public Observable<Message> getReceivedMessagesOfCurrentUser() {
        return Observable.from(messages.find("{receiver: #}", Identity.getCurrentUser().getId()).as(Message.class));
    }

    public Observable<Void> save(Message message) {
        return Observable.create(subscriber -> {
            messages.save(message);
            subscriber.onCompleted();
        });
    }



}

package com.koala.app.server.repository;

import com.koala.app.server.models.Message;
import rx.Observable;

import java.util.List;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 25.11.2016.
 */
public class MessagesRepository {

    private static MessagesRepository _instance;


    private MessagesRepository() {


    }

    public Observable<List<Message>> getMessages() {
        return null;
    }

    public Observable<Message> getMessageById(String MessageId) {
        return null;
    }

    public void sendMessage(Message message) {

    }
}

package com.koala.app.client.data.message;

import rx.Observable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 25.11.2016.
 */
public class MessagesRemoteDataSource implements MessagesDataSource {

    private static MessagesRemoteDataSource _instance;

    private final static Map<String, Message> messages;

    static {
        messages = new HashMap<>();
    }


    private MessagesRemoteDataSource() { }

    public MessagesRemoteDataSource getInstance() {
        if (_instance == null)
            _instance = new MessagesRemoteDataSource();

        return _instance;
    }

    @Override
    public Observable<List<Message>> getMessages() {
        return null;
    }

    @Override
    public Observable<Message> getMessageById(String userId) {
        return null;
    }

    @Override
    public void sendMessage(Message message) {

    }
}

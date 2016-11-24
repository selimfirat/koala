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
public class MessagesLocalDataSource implements MessagesDataSource {

    private static MessagesLocalDataSource _instance;

    private final static Map<String, Message> messages;

    static {
        messages = new HashMap<>();
    }


    private MessagesLocalDataSource() { }

    public MessagesLocalDataSource getInstance() {
        if (_instance == null)
            _instance = new MessagesLocalDataSource();

        return _instance;
    }

    @Override
    public Observable<List<Message>> getMessages() {
        return null;
    }

    @Override
    public Observable<Message> getMessageWithId(String userId) {
        return null;
    }

    @Override
    public void sendMessage(Message message) {

    }
}

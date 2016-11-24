package com.koala.app.client.data.message;

import rx.Observable;

import java.util.List;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 25.11.2016.
 */
public class MessagesRepository implements MessagesDataSource {

    private static MessagesRepository _instance;

    private MessagesLocalDataSource messagesLocalDataSource;

    private MessagesRepository(MessagesLocalDataSource MessagesLocalDataSource) {

        this.messagesLocalDataSource = MessagesLocalDataSource;

    }

    public static MessagesRepository getInstance(MessagesLocalDataSource messagesLocalDataSource) {
        if (_instance == null)
            _instance = new MessagesRepository(messagesLocalDataSource);

        return _instance;
    }

    @Override
    public Observable<List<Message>> getMessages() {
        return null;
    }

    @Override
    public Observable<Message> getMessageWithId(String MessageId) {
        return null;
    }

    @Override
    public void sendMessage(Message message) {

    }
}

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

    private MessagesDataSource messagesLocalDataSource;
    private MessagesDataSource messagesRemoteDataSource;

    private MessagesRepository(MessagesDataSource messagesLocalDataSource, MessagesDataSource messagesRemoteDataSource) {

        this.messagesLocalDataSource = messagesLocalDataSource;
        this.messagesRemoteDataSource = messagesRemoteDataSource;

    }

    public static MessagesRepository getInstance(MessagesDataSource messagesLocalDataSource, MessagesDataSource messagesRemoteDataSource) {
        if (_instance == null)
            _instance = new MessagesRepository(messagesLocalDataSource, messagesRemoteDataSource);

        return _instance;
    }

    @Override
    public Observable<List<Message>> getMessages() {
        return null;
    }

    @Override
    public Observable<Message> getMessageById(String MessageId) {
        return null;
    }

    @Override
    public void sendMessage(Message message) {

    }
}

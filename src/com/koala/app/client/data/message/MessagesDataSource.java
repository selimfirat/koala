package com.koala.app.client.data.message;

import rx.Observable;

import java.util.List;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 25.11.2016.
 */
public interface MessagesDataSource {

    Observable<List<Message>> getMessages();

    Observable<Message> getMessageWithId(String userId);

    void sendMessage(Message message);

}

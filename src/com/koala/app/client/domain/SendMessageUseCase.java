package com.koala.app.client.domain;

import com.koala.app.client.data.message.Message;
import com.koala.app.client.data.message.MessagesRepository;
import com.koala.app.client.data.user.User;
import rx.Observable;
import rx.functions.Func1;

import java.util.Date;

/**
 * Created by mrsfy on 13-Dec-16.
 */
public class SendMessageUseCase extends UseCase {

    private MessagesRepository messagesRepository = MessagesRepository.getInstance();


    private Message message;

    public SendMessageUseCase(User to, String message) {
        this.message = new Message(
                to,
                null, // TODO: get current user
                message,
                new Date()
        );
    }

    @Override
    protected Observable<Message> buildUseCaseObservable() {
        messagesRepository.save(message);
        return Observable.just(message);
    }

}

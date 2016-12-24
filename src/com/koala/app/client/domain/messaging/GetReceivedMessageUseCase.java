package com.koala.app.client.domain.messaging;

import com.koala.app.client.data.message.Message;
import com.koala.app.client.data.message.MessagesRepository;
import com.koala.app.client.domain.UseCase;
import rx.Observable;

/**
 * Created by BurakMac on 24.12.2016.
 */
public class GetReceivedMessageUseCase extends UseCase {
    public GetReceivedMessageUseCase() {
    }

    @Override
    protected Observable<Message> buildUseCaseObservable() {
        return MessagesRepository.getInstance().getReceivedMessagesOfCurrentUser();
    }
}

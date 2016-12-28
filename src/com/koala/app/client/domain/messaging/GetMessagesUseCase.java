package com.koala.app.client.domain.messaging;

import com.fasterxml.jackson.core.type.TypeReference;
import com.koala.app.client.domain.SocketHelper;
import com.koala.app.client.models.message.Message;
import com.koala.app.client.domain.UseCase;
import rx.Observable;

import java.util.List;

/**
 * Created by BurakMac on 24.12.2016.
 */
public class GetMessagesUseCase extends UseCase {
    public GetMessagesUseCase() {
    }

    @Override
    protected Observable<Message> buildUseCaseObservable() {

        return Observable
                .create(subscriber ->
                        SocketHelper.echo("GET_MESSAGES", null, new TypeReference<List<Message>>() {},
                                res -> {
                                    res.forEach(subscriber::onNext);
                                    subscriber.onCompleted();
                                })
                );
    }
}
package com.koala.app.client.domain.messaging;

import com.koala.app.client.domain.SocketHelper;
import com.koala.app.client.models.message.Message;
import com.koala.app.client.models.user.Identity;
import com.koala.app.client.models.user.User;
import com.koala.app.client.domain.UseCase;
import rx.Observable;

import java.util.Date;

/**
 * Created by mrsfy on 13-Dec-16.
 */
public class SendMessageUseCase extends UseCase {

    private Message message;

    public SendMessageUseCase(String to, String message) {
        this.message = new Message(
                Identity.getCurrentUser().getId(),
                to,
                message,
                new Date()
        );
    }

    @Override
    protected Observable<Message> buildUseCaseObservable() {
        return Observable.create(subscriber -> {

            SocketHelper.echo("SEND_MESSAGE", message, String.class, res -> {
                System.out.print(res);
                subscriber.onCompleted();
            });

        });
    }

}
package com.koala.app.client.domain.houses;

import com.koala.app.client.data.SocketHelper;
import com.koala.app.client.data.SocketListener;
import com.koala.app.client.domain.UseCase;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by mrsfy on 24-Dec-16.
 */
public class RemoveHouseUseCase extends UseCase {

    private final String id;

    public RemoveHouseUseCase(String id) {
        this.id = id;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return Observable.create(subscriber -> {

            SocketHelper.echo("REMOVE_HOUSE", id, String.class, res -> {
                System.out.println(id + " " + res);
                subscriber.onCompleted();
            });

        });

    }
}

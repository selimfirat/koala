package com.koala.app.client.domain.authentication;

import com.koala.app.client.data.SocketHelper;
import com.koala.app.client.data.user.Identity;
import com.koala.app.client.domain.UseCase;
import rx.Observable;

/**
 * Created by mrsfy on 13-Dec-16.
 */
public class LogoutUseCase extends UseCase{

    @Override
    protected Observable<Void> buildUseCaseObservable() {
        return handleSocket().doOnCompleted(Identity::logout);
    }

    private Observable<Void> handleSocket() {
        return Observable.create(subscriber -> {
            SocketHelper.echo("LOGOUT", String.class, res -> {
                subscriber.onCompleted();
                System.out.println(res);
            });
        });
    }
}

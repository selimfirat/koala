package com.koala.app.client.domain;

import com.koala.app.client.data.user.User;
import javafx.application.Platform;
import rx.Observable;
import rx.SingleSubscriber;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

import java.util.concurrent.Executor;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 25.11.2016.
 */
public abstract class UseCase {

    private Subscription subscription = Subscriptions.empty();

    protected abstract Observable buildUseCaseObservable();

    @SuppressWarnings("unchecked")
    public void execute(Subscriber useCaseSubscriber) {
        subscription = buildUseCaseObservable()
                .observeOn(Schedulers.from(new Executor() {
                    @Override
                    public void execute(Runnable command) {
                        Platform.runLater(command);
                    }
                }))
                .subscribe(useCaseSubscriber);
    }

    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}

package com.koala.app.client.domain;

import rx.*;
import rx.subscriptions.Subscriptions;

/**
 * Created by mrsfy on 04-Dec-16.
 */
public abstract class SingleUseCase {

    private Subscription subscription = Subscriptions.empty();

    protected abstract Single buildUseCaseSingle();

    @SuppressWarnings("unchecked")
    public void execute(SingleSubscriber useCaseSubscriber) {
        subscription = buildUseCaseSingle().subscribe(useCaseSubscriber);
    }

    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

}
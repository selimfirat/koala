package com.koala.app.client.old.observables;

import com.koala.app.client.data.user.UserEntity;
import rx.SingleSubscriber;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 23.11.2016.
 */
public class SubscriberLogin extends SingleSubscriber<UserEntity> {
    @Override
    public void onSuccess(UserEntity userEntity) {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}

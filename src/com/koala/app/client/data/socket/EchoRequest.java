package com.koala.app.client.data.socket;

import rx.Single;

/**
 * Created by mrsfy on 04-Dec-16.
 */
public class EchoRequest<T> {

    public enum Type {
        GET_HOUSE_BY_ID, SAVE_HOUSE, DELETE_HOUSE_BY_ID, ADD_USER, GET_USER_BY_USERNAME_AND_PASSWORD, SAVE_USER, GET_USER_BY_ID, GET_HOUSES
    }

    private EchoRequest.Type type;

    public EchoRequest(EchoRequest.Type type) {
        this.type = type;
    }

    public <R> Single<T> send(R o) {

        EchoRequestMessage<R> message = new EchoRequestMessage<R>(type, o);

        return Single.create(subscriber -> {

        });
    }

    public Single<T> send() {
        return send(null);
    }

}

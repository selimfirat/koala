package com.koala.app.client.data.socket;

import rx.Single;

/**
 * Created by mrsfy on 04-Dec-16.
 */
public class EchoRequest<T> {

    private EchoRequestType type;

    public EchoRequest(EchoRequestType type) {
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

package com.koala.app.client.data.socket;

/**
 * Created by mrsfy on 04-Dec-16.
 */
public class EchoRequestMessage<R> {

    private EchoRequest.Type type;
    private R message;

    public EchoRequestMessage(EchoRequest.Type type, R message) {
        this.type = type;
        this.message = message;
    }
}

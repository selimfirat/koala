package com.koala.app.client.data.socket;

import java.lang.reflect.ParameterizedType;

/**
 * Created by mrsfy on 04-Dec-16.
 */
public class EchoRequestMessage<R> {

    private EchoRequestType type;
    private R message;
    private String genericType;

    public EchoRequestMessage(EchoRequestType type, R message) {
        this.type = type;
        this.message = message;
        this.genericType = ((Class<R>) ((ParameterizedType)getClass().getGenericSuperclass())
                        .getActualTypeArguments()[0]).getClass().getName();

    }

    public EchoRequestType getType() {
        return type;
    }

    public void setType(EchoRequestType type) {
        this.type = type;
    }

    public R getMessage() {
        return message;
    }

    public void setMessage(R message) {
        this.message = message;
    }

    public String getGenericType() {
        return genericType;
    }

    public void setGenericType(String genericType) {
        this.genericType = genericType;
    }
}

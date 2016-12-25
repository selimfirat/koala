package com.koala.app.client.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.koala.app.client.data.house.House;
import com.koala.app.client.data.user.User;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by mrsfy on 22-Dec-16.
 */
public class SocketHelper {

    private static ObjectMapper mapper = new ObjectMapper();

    public static <T, S> Emitter echo(String eventName, T data, Class<S> clazz, SocketListener<S> listener) {

        System.out.println(eventName + " " + data);

        Emitter emitter = null;
        try {
            emitter = SocketProvider.getSocket()
                    .emit(eventName, new ObjectMapper().writeValueAsString(data))
                    .once(eventName + "_RESULT", objects -> {

                            S obj = null;
                            if (objects.length > 0) {
                                if (objects[0] != null) {
                                    if (objects[0] instanceof String) {
                                        obj = (S) objects[0];
                                    } else {
                                        try {
                                                obj = mapper.readValue(objects[0].toString(), clazz);
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        listener.call(obj);
                    });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return emitter;
    }

    public static <T> Emitter echo(String eventName, Class<T> clazz, SocketListener<T> listener) {

        return SocketHelper.echo(eventName, null, clazz, listener);
    }

    public static <T> Emitter emit(String eventName, T obj) {
        return SocketProvider.getSocket()
                .emit(eventName, obj);
    }

    public static <T> Emitter emit(String eventName) {
        return emit(eventName, null);
    }
    public static <T, S> Emitter echo(String eventName, T data, TypeReference<S> clazz, SocketListener<S> listener) {

        System.out.println(eventName + " " + data);

        Emitter emitter = null;
        try {
            emitter = SocketProvider.getSocket()
                    .emit(eventName, new ObjectMapper().writeValueAsString(data))
                    .once(eventName + "_RESULT", objects -> {

                        S obj = null;
                        if (objects.length > 0) {
                            if (objects[0] != null) {
                                if (objects[0] instanceof String) {
                                    obj = (S) objects[0];
                                } else {
                                    try {
                                        obj = mapper.readValue(objects[0].toString(), clazz);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                        listener.call(obj);
                    });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return emitter;
    }
}

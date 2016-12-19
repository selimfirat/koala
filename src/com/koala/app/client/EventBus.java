package com.koala.app.client;

import rx.Observable;
import rx.subjects.PublishSubject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrsfy on 18-Dec-16.
 */
public class EventBus {

    private static Map<EventType, PublishSubject<Object>> bus = new HashMap<>();

    static {
        for (EventType type : EventType.values())
            bus.put(type, PublishSubject.create());
    }

    public static Observable<Object> toObservable(EventType type) {
        return bus.get(type);
    }

    public static void trigger(EventType type, Object data) {
        bus.get(type).onNext(data);
    }

    public static void trigger(EventType type) {
        trigger(type, null);
    }

}
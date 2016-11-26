package com.koala.app.client.domain;

import rx.Observable;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 25.11.2016.
 */
public interface UseCase<T> {

    Observable<T> build();
}

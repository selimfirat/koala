package com.koala.app.client.data.user;

import rx.Observable;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 24.11.2016.
 */
public interface UsersDataSource {

    Observable<User> getUserById(String userId);

    Observable<User> register(User user);

    Observable<User> login(User user);

    void updateUser(User user);
}
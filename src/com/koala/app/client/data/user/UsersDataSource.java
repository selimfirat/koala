package com.koala.app.client.data.user;

import rx.Observable;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 24.11.2016.
 */
public interface UsersDataSource {

    Observable<User> getUser(String userId);
    Observable<User> getUser(String username, String password);

    Observable<Void> addUser(User user);
    Observable<Void> updateUser(User user);
}
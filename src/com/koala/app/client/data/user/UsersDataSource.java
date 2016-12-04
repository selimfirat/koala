package com.koala.app.client.data.user;

import rx.Single;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 24.11.2016.
 */
public interface UsersDataSource {

    Single<User> getUser(String userId);
    Single<User> getUser(String username, String password);

    Single<Void> addUser(User user);
    Single<Void> updateUser(User user);
}
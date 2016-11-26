package com.koala.app.server.repository;

import com.koala.app.server.models.User;
import rx.Observable;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 24.11.2016.
 */
public class UsersRepository  {


    private UsersRepository() {

    }

    public Observable<User> getUserById(String userId) {
        return null;
    }

    public Observable<User> register(User user) {
        return null;
    }

    public Observable<User> login(User user) {
        return null;
    }

    public void updateUser(User user) {

    }
}

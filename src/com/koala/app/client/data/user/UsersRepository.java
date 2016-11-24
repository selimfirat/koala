package com.koala.app.client.data.user;

import rx.Observable;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 24.11.2016.
 */
public class UsersRepository implements UsersDataSource {

    private static UsersRepository _instance;

    private UsersLocalDataSource usersLocalDataSource;

    private UsersRepository(UsersLocalDataSource UsersLocalDataSource) {

        this.usersLocalDataSource = UsersLocalDataSource;

    }

    public static UsersRepository getInstance(UsersLocalDataSource usersLocalDataSource) {
        if (_instance == null)
            _instance = new UsersRepository(usersLocalDataSource);

        return _instance;
    }
    
    @Override
    public Observable<User> getUserWithId(String userId) {
        return null;
    }

    @Override
    public Observable<User> register(User user) {
        return null;
    }

    @Override
    public Observable<User> login(User user) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }
}

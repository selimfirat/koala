package com.koala.app.client.data.user;

import rx.Single;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 24.11.2016.
 */
public class UsersRepository implements UsersDataSource {

    private static UsersRepository _instance;

    private UsersRemoteDataSource usersRemoteDataSource;

    private UsersRepository(UsersRemoteDataSource usersRemoteDataSource) {

        this.usersRemoteDataSource = usersRemoteDataSource;

    }

    public static UsersRepository getInstance(UsersRemoteDataSource usersRemoteDataSource) {
        if (_instance == null)
            _instance = new UsersRepository(usersRemoteDataSource);

        return _instance;
    }

    @Override
    public Single<User> getUser(String userId) {
        return null;
    }

    @Override
    public Single<User> getUser(String username, String password) {
        return null;
    }

    @Override
    public Single<Void> addUser(User user) {
        return null;
    }

    @Override
    public Single<Void> updateUser(User user) {
        return null;
    }
}

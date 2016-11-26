package com.koala.app.client.data.user;

import rx.Observable;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 24.11.2016.
 */
public class UsersRemoteDataSource implements UsersDataSource {

    private static UsersRemoteDataSource _instance;

    private final static Map<String, User> users;

    static {
        users = new HashMap<>();
    }

    private UsersRemoteDataSource() { }

    public UsersRemoteDataSource getInstance() {
        if (_instance == null)
            _instance = new UsersRemoteDataSource();

        return _instance;
    }

    @Override
    public Observable<User> getUserById(String userId) {
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

package com.koala.app.client.data.user;

import com.koala.app.client.data.socket.EchoRequest;
import com.koala.app.client.data.socket.EchoRequestType;
import rx.Single;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 24.11.2016.
 */
public class UsersRemoteDataSource implements UsersDataSource {

    private static UsersRemoteDataSource _instance;

    private UsersRemoteDataSource() { }

    public static UsersRemoteDataSource getInstance() {
        if (_instance == null)
            _instance = new UsersRemoteDataSource();

        return _instance;
    }

    @Override
    public Single<User> getUser(String userId) {
        return new EchoRequest<User>(EchoRequestType.GET_USER_BY_ID).send(userId);
    }

    @Override
    public Single<User> getUser(String username, String password) {
        Map<String, String> data = new HashMap<>();
        data.put("username", username);
        data.put("password", password);
        return new EchoRequest<User>(EchoRequestType.GET_USER_BY_USERNAME_AND_PASSWORD).send(data);
    }

    @Override
    public Single<Void> addUser(User user) {
        return saveUser(user);
    }

    @Override
    public Single<Void> updateUser(User user) {
        return saveUser(user);
    }

    private Single<Void> saveUser(User user) {
        return new EchoRequest<Void>(EchoRequestType.SAVE_USER).send(user);
    }

}
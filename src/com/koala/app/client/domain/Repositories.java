package com.koala.app.client.domain;

import com.koala.app.client.data.user.UsersRemoteDataSource;
import com.koala.app.client.data.user.UsersRepository;

/**
 * Created by mrsfy on 01-Dec-16.
 * Mediator
 */
public class Repositories {



    private Repositories() {
    }

    public static UsersRepository getUsersRepository() {
        return UsersRepository.getInstance(UsersRemoteDataSource.getInstance());
    }
}

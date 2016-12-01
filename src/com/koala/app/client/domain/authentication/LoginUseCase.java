package com.koala.app.client.domain.authentication;

import com.koala.app.client.data.user.User;
import com.koala.app.client.domain.Repositories;
import com.koala.app.client.domain.UseCase;
import rx.Observable;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 25.11.2016.
 */
public class LoginUseCase extends UseCase {

    private String username, password;

    public LoginUseCase(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    protected Observable<User> buildUseCaseObservable() {
        return Repositories.getUsersRepository().getUser(username, password);
    }
}

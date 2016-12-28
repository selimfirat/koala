package com.koala.app.client.domain.authentication;

import com.koala.app.client.domain.SocketHelper;
import com.koala.app.client.models.user.Identity;
import com.koala.app.client.models.user.User;
import com.koala.app.client.domain.UseCase;
import rx.Observable;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 25.11.2016.
 */
public class LoginUseCase extends UseCase {


    private String username, password;

    public LoginUseCase(String username, String password) {
        this.username = username;
        this.password = Encryption.getMD5(password);
    }

    @Override
    protected Observable<User> buildUseCaseObservable() {
        return handleSocket().flatMap(user -> {
            if (user == null)
                return Observable.error(new WrongUsernameOrPasswordException());


            Identity.setCurrentUser(user);

            return Observable.just(user);
        });
    }

    private Observable<User> handleSocket() {
        return Observable.create(subscriber -> {
            Map<String, String> data = new HashMap<>();
            data.put("username", username);
            data.put("password", password);

            SocketHelper.echo("LOGIN", data, User.class, res -> {

                System.out.println(res);
                subscriber.onNext(res);
            });
        });
    }

    private class WrongUsernameOrPasswordException extends Throwable {
        public WrongUsernameOrPasswordException() {
            super();
        }

        public WrongUsernameOrPasswordException(String message) {
            super(message);
        }

        public WrongUsernameOrPasswordException(String message, Throwable cause) {
            super(message, cause);
        }

        public WrongUsernameOrPasswordException(Throwable cause) {
            super(cause);
        }

        protected WrongUsernameOrPasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
}

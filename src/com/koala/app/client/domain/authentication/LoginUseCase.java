package com.koala.app.client.domain.authentication;

import com.koala.app.client.data.user.User;
import com.koala.app.client.data.user.UsersRepository;
import com.koala.app.client.domain.UseCase;
import rx.Observable;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 25.11.2016.
 */
public class LoginUseCase extends UseCase {

    private UsersRepository usersRepository = UsersRepository.getInstance();

    private String username, password;

    public LoginUseCase(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    protected Observable<User> buildUseCaseObservable() {
        return usersRepository.findByUsernameAndPassword(username, password).flatMap(user -> {
            if (user == null)
                return Observable.error(new WrongUsernameOrPasswordException());

            return Observable.just(user);
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

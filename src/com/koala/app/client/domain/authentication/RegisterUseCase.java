package com.koala.app.client.domain.authentication;

import com.koala.app.client.data.user.User;
import com.koala.app.client.data.user.UsersRepository;
import com.koala.app.client.domain.UseCase;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by mrsfy on 12-Dec-16.
 */
public class RegisterUseCase extends UseCase {

    private User user;
    private UsersRepository usersRepository = UsersRepository.getInstance();

    public RegisterUseCase(String fullName, String username, String password, String phoneNumber, String email) {
        user = new User();
        user.setFullName(fullName);
        user.setUsername(username);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);
    }

    @Override
    protected Observable<Void> buildUseCaseObservable() {
        return usersRepository.save(user);
    }
}

package com.koala.app.client.domain.authentication;

import com.koala.app.client.data.user.User;
import com.koala.app.client.data.user.UsersRepository;
import com.koala.app.client.domain.UseCase;
import rx.Observable;
import rx.functions.Func1;

import javax.xml.bind.ValidationException;

/**
 * Created by mrsfy on 12-Dec-16.
 */
public class RegisterUseCase extends UseCase {

    private User user;
    private UsersRepository usersRepository = UsersRepository.getInstance();
    private String passwordAgain;

    public RegisterUseCase(String fullName, String username, String password, String passwordAgain, String phoneNumber, String email) {
        user = new User();
        user.setFullName(fullName);
        user.setUsername(username);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);
        this.passwordAgain = passwordAgain;
    }

    @Override
    protected Observable<Void> buildUseCaseObservable()
    {
        ValidationException vex = null;
        if (user.getUsername().length() < 5)
            vex = new ValidationException("Username must be at least 5 characters!");
        else if (user.getPassword().length() < 6)
            vex = new ValidationException("Password must be at least 6 characters!");
        else if (!user.getEmail().matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$"))
            vex = new ValidationException("Please enter valid email address!");
        else if (!passwordAgain.equals(user.getPassword()))
            vex = new ValidationException("Passwords do not match!");
        else if (user.getFullName().isEmpty())
            vex = new ValidationException("Name field cannot be empty!");
        else if (usersRepository.usernameExists(user.getUsername()))
            vex = new ValidationException("Username "+ user.getUsername() + " is already in use!");

        if (vex != null)
            return Observable.error(vex);

        return usersRepository.save(user);
    }
}

package com.koala.app.client.domain.authentication;

import com.koala.app.client.domain.SocketHelper;
import com.koala.app.client.models.user.User;
import com.koala.app.client.domain.UseCase;
import rx.Observable;
import rx.Subscriber;

import javax.xml.bind.ValidationException;

/**
 * Created by mrsfy on 12-Dec-16.
 */
public class RegisterUseCase extends UseCase {

    private User user;
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


        if (vex != null)
            return Observable.error(vex);

        user.setPassword(Encryption.getMD5(user.getPassword()));


        return Observable.create(subscriber -> SocketHelper.echo("REGISTER", user, String.class, res -> {

            if (res.equals("USERNAME_EXISTS"))
                subscriber.onError(new ValidationException("This username already exists!"));
            else if (res.equals("EMAIL_EXISTS"))
                subscriber.onError(new ValidationException("This email already exists!"));
            else {
                System.out.println(res);
                subscriber.onCompleted();
            }

        }));
    }
}

package com.koala.app.client.data.user;

import com.koala.app.client.data.house.HousesRepository;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by mrsfy on 03-Dec-16.
 */

public class UsersRepository {

    private static UsersRepository _instance;

    //getInstance method to return instance or create a user repository if it does not exist
    public static UsersRepository getInstance() {
        if (_instance == null)
            _instance = new UsersRepository();

        return _instance;
    }

    private UsersRepository(){ }

    //setJongo method to set users that exists in database
    public void setJongo(Jongo jongo) {
        this.users = jongo.getCollection("users");
    }


    private MongoCollection users;

    //fidById method to find users in database from ID number
    public Observable<User> findById(String id) {
        return Observable.just(users.findOne(id).as(User.class));
    }

    //findByUsernameAndPassword method to find a user from its username and password only
    public Observable<User> findByUsernameAndPassword(String username, String password) {
        return Observable.just(users.findOne("{username: #, password: #}", username, password).as(User.class));
    }

    //save method to add a user
    public Observable<Void> save(User user) {
        return Observable.create(subscriber -> {
            users.save(user);
            subscriber.onCompleted();
        });
    }

    //usernameExists method to identify if the given username already exists or not
    public boolean usernameExists(String username) {
        return users.count("{username: #}", username) > 0;
    }

    //logout method
    public Observable<Void> logout() {

        return Observable.empty();
    }


}

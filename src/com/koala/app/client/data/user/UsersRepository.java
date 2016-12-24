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

    public static UsersRepository getInstance() {
        if (_instance == null)
            _instance = new UsersRepository();

        return _instance;
    }

    private UsersRepository(){ }

    public void setJongo(Jongo jongo) {
        this.users = jongo.getCollection("users");
    }


    private MongoCollection users;

    //fidById method to find users in database from ID number
    public Observable<User> findById(String id) {
        return Observable.just(users.findOne(id).as(User.class));
    }

    public Observable<User> findByUsernameAndPassword(String username, String password) {
        return Observable.just(users.findOne("{username: #, password: #}", username, password).as(User.class));
    }

    public Observable<Void> save(User user) {
        return Observable.create(subscriber -> {
            users.save(user);
            subscriber.onCompleted();
        });
    }

    public boolean usernameExists(String username) {
        return users.count("{username: #}", username) > 0;
    }

    public Observable<Void> logout() {

        return Observable.empty();
    }


}

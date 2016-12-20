package com.koala.app.client.data.house;

import com.mongodb.WriteResult;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import rx.Observable;
import rx.Subscriber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrsfy on 03-Dec-16.
 */

public class HousesRepository {

    private static HousesRepository _instance;

    public static HousesRepository getInstance() {
        if (_instance == null)
            _instance = new HousesRepository();

        return _instance;
    }

    private HousesRepository(){ }

    public void setJongo(Jongo jongo) {
        this.houses = jongo.getCollection("houses");
    }



    private MongoCollection houses;


    public Observable<House> findById(String id) {
        return Observable.just(houses.findOne(id).as(House.class));
    }

    public Observable<House> findBySeller(String sellerId) {
        return Observable.from(houses.find("{seller_id: #}", sellerId).as(House.class));
    }

    public Observable<Void> save(House house) {
        System.out.println("save method");
        WriteResult a = houses.save(house);
        System.out.println(a);
        return Observable.empty();
    }

    public Observable<Void> removeById(String houseId) {
        houses.remove(houseId);
        return Observable.empty();
    }

}
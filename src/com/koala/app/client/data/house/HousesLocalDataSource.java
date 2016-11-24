package com.koala.app.client.data.house;

import rx.Observable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 24.11.2016.
 */
public class HousesLocalDataSource implements HousesDataSource {

    private static HousesLocalDataSource _instance;

    private final static Map<String, House> houses;

    static {
        houses = new HashMap<>();
    }


    private HousesLocalDataSource() { }

    public HousesLocalDataSource getInstance() {
        if (_instance == null)
            _instance = new HousesLocalDataSource();

        return _instance;
    }

    @Override
    public Observable<List<House>> getHouses() {
        return Observable
                .from(houses.values())
                .toList();
    }

    @Override
    public Observable<House> getHouseWithId(String houseId) {
        final House house = houses.get(houseId);

        if (house != null)
            return Observable.just(house);
        else
            return Observable.empty();
    }

    @Override
    public void addHouse(House house) {
        addOrUpdate(house);
    }

    @Override
    public void updateHouse(House house) {
        addOrUpdate(house);
    }

    @Override
    public void deleteHouse(String houseId) {
        houses.remove(houseId);
    }


    private void addOrUpdate(House house) {
        houses.put(house.getId(), house);
    }
}

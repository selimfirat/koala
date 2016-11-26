package com.koala.app.server.repository;

import com.koala.app.server.models.House;
import rx.Observable;

import java.util.List;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 24.11.2016.
 */
public class HousesRepository {

    private static HousesRepository _instance;

    private HousesRepository() {


    }


    public Observable<List<House>> getHouses() {
        return housesLocalDataSource.getHouses();
    }

    public Observable<House> getHouseById(String houseId) {
        return housesLocalDataSource.getHouseById(houseId);
    }

    public void addHouse(House house) {
        housesLocalDataSource.addHouse(house);
    }

    public void updateHouse(House house) {
        housesLocalDataSource.updateHouse(house);
    }

    public void deleteHouse(String houseId) {
        housesLocalDataSource.deleteHouse(houseId);
    }
}

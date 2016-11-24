package com.koala.app.client.data.house;

import rx.Observable;

import java.util.List;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 24.11.2016.
 */
public class HousesLocalDataSource implements HousesDataSource {
    @Override
    public Observable<List<House>> getHouses() {
        return null;
    }

    @Override
    public Observable<House> getHouse(String HouseId) {
        return null;
    }

    @Override
    public void addHouse(House House) {

    }

    @Override
    public void updateHouse(House house) {

    }

    @Override
    public void deleteHouse(String HouseId) {

    }
}

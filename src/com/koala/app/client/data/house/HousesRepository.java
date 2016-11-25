package com.koala.app.client.data.house;

import rx.Observable;

import java.util.List;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 24.11.2016.
 */
public class HousesRepository implements HousesDataSource {

    private static HousesRepository _instance;

    private HousesDataSource housesLocalDataSource;
    private HousesDataSource housesRemoteDataSource;

    private HousesRepository(HousesDataSource housesLocalDataSource, HousesDataSource housesRemoteDataSource) {

        this.housesLocalDataSource = housesLocalDataSource;
        this.housesRemoteDataSource = housesRemoteDataSource;

    }

    public static HousesRepository getInstance(HousesLocalDataSource housesLocalDataSource, HousesRemoteDataSource housesRemoteDataSource) {
        if (_instance == null)
            _instance = new HousesRepository(housesLocalDataSource, housesRemoteDataSource);

        return _instance;
    }

    @Override
    public Observable<List<House>> getHouses() {
        return housesLocalDataSource.getHouses();
    }

    @Override
    public Observable<House> getHouseWithId(String houseId) {
        return housesLocalDataSource.getHouseWithId(houseId);
    }

    @Override
    public void addHouse(House house) {
        housesLocalDataSource.addHouse(house);
    }

    @Override
    public void updateHouse(House house) {
        housesLocalDataSource.updateHouse(house);
    }

    @Override
    public void deleteHouse(String houseId) {
        housesLocalDataSource.deleteHouse(houseId);
    }
}

package com.koala.app.client.data.house;

import rx.Single;

import java.util.List;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 24.11.2016.
 */
public class HousesRepository implements HousesDataSource {

    private static HousesRepository _instance;

    private HousesDataSource housesRemoteDataSource;

    private HousesRepository( HousesDataSource housesRemoteDataSource) {

        this.housesRemoteDataSource = housesRemoteDataSource;

    }

    public static HousesRepository getInstance(HousesRemoteDataSource housesRemoteDataSource) {
        if (_instance == null)
            _instance = new HousesRepository(housesRemoteDataSource);

        return _instance;
    }

    @Override
    public Single<List<House>> getHouses() {
        return housesRemoteDataSource.getHouses();
    }

    @Override
    public Single<House> getHouseById(String houseId) {
        return housesRemoteDataSource.getHouseById(houseId);
    }

    @Override
    public Single<Void> addHouse(House house) {
        return housesRemoteDataSource.addHouse(house);
    }

    @Override
    public Single<Void> updateHouse(House house) {
        return housesRemoteDataSource.updateHouse(house);
    }

    @Override
    public Single<Void> deleteHouse(String houseId) {
        return housesRemoteDataSource.deleteHouse(houseId);
    }
}

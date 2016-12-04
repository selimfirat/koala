package com.koala.app.client.data.house;

import rx.Single;

import java.util.List;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 24.11.2016.
 */
public interface HousesDataSource {

    Single<List<House>> getHouses();

    Single<House> getHouseById(String houseId);

    Single<Void> addHouse(House house);

    Single<Void> updateHouse(House house);

    Single<Void> deleteHouse(String houseId);
}

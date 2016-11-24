package com.koala.app.client.data.house;

import rx.Observable;

import java.util.List;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 24.11.2016.
 */
public interface HousesDataSource {

    Observable<List<House>> getHouses();

    Observable<House> getHouse(String HouseId);

    void addHouse(House House);

    void updateHouse(House house);

    void deleteHouse(String HouseId);
}

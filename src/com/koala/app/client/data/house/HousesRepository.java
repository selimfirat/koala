package com.koala.app.client.data.house;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 24.11.2016.
 */
public class HousesRepository {

    private static HousesRepository _instance;
    HousesLocalDataSource housesLocalDataSource;

    private HousesRepository(HousesLocalDataSource housesLocalDataSource) {

        this.housesLocalDataSource = housesLocalDataSource;

    }

    public static HousesRepository getInstance(HousesLocalDataSource housesLocalDataSource) {
        if (_instance == null)
            _instance = new HousesRepository(housesLocalDataSource);

        return _instance;
    }
}

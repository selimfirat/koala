package com.koala.app.client.data.house;

import com.koala.app.client.data.socket.EchoRequest;
import rx.Single;

import java.util.List;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 24.11.2016.
 */
public class HousesRemoteDataSource implements HousesDataSource {

    private static HousesRemoteDataSource _instance;


    private HousesRemoteDataSource() { }

    public HousesRemoteDataSource getInstance() {
        if (_instance == null)
            _instance = new HousesRemoteDataSource();

        return _instance;
    }

    @Override
    public Single<List<House>> getHouses() {
        return new EchoRequest<List<House>>(EchoRequest.Type.GET_HOUSES).send();
    }

    @Override
    public Single<House> getHouseById(String houseId) {
        return new EchoRequest<House>(EchoRequest.Type.GET_HOUSE_BY_ID).send(houseId);
    }

    @Override
    public Single<Void> addHouse(House house) {
        return updateHouse(house);
    }

    @Override
    public Single<Void> updateHouse(House house) {
        return saveHouse(house);
    }

    private Single<Void> saveHouse(House house) {
        return new EchoRequest<Void>(EchoRequest.Type.SAVE_HOUSE).send(house);
    }

    @Override
    public Single<Void> deleteHouse(String houseId) {
        return new EchoRequest<Void>(EchoRequest.Type.DELETE_HOUSE_BY_ID).send(houseId);
    }

}

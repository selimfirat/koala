package com.koala.app.client.domain.houses;

import com.koala.app.client.data.house.House;
import com.koala.app.client.data.house.HousesRepository;
import com.koala.app.client.domain.UseCase;
import rx.Observable;

/**
 * Created by mrsfy on 13-Dec-16.
 */
class SaveHouseUseCase extends UseCase{

    private House house;

    public SaveHouseUseCase(House house) {
        this.house = house;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return HousesRepository.getInstance().save(house);
    }
}

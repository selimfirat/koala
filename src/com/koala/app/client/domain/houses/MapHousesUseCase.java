package com.koala.app.client.domain.houses;

import com.koala.app.client.data.house.House;
import com.koala.app.client.data.house.HousesRepository;
import com.koala.app.client.domain.UseCase;
import rx.Observable;

/**
 * Created by mrsfy on 20-Dec-16.
 */
public class MapHousesUseCase extends UseCase{


    public MapHousesUseCase() {

    }

    @Override
    protected Observable<House> buildUseCaseObservable() {

        return HousesRepository.getInstance().findAll();
    }
}

package com.koala.app.client.domain.houses;

import com.koala.app.client.data.house.HousesRepository;
import com.koala.app.client.domain.UseCase;
import rx.Observable;

/**
 * Created by mrsfy on 13-Dec-16.
 */
public class DeleteHouseUseCase extends UseCase {


    private String houseId;

    public DeleteHouseUseCase(String houseId) {
        this.houseId = houseId;
    }

    @Override
    protected Observable<Void> buildUseCaseObservable() {
        return HousesRepository.getInstance().removeById(houseId);
    }
}

package com.koala.app.client.domain.houses;

import com.koala.app.client.data.house.House;
import com.koala.app.client.data.house.HousesRepository;
import com.koala.app.client.data.user.User;
import com.koala.app.client.domain.UseCase;
import com.koala.app.client.data.user.Identity;
import rx.Observable;

/**
 * Created by mrsfy on 13-Dec-16.
 */
public class GetOwnHousesUseCase extends UseCase {
    @Override
    protected Observable<House> buildUseCaseObservable() {
        return HousesRepository.getInstance().findBySeller(Identity.getCurrentUser().getId());
    }
}

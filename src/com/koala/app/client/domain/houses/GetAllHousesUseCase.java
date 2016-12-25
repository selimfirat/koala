package com.koala.app.client.domain.houses;

import com.fasterxml.jackson.core.type.TypeReference;
import com.koala.app.client.data.SocketHelper;
import com.koala.app.client.data.house.House;
import com.koala.app.client.domain.UseCase;
import rx.Observable;
import java.util.List;

/**
 * Created by mrsfy on 20-Dec-16.
 */
public class GetAllHousesUseCase extends UseCase{


    public GetAllHousesUseCase() {

    }

    @Override
    protected Observable<House> buildUseCaseObservable() {

        return Observable
                .create(subscriber ->
                        SocketHelper.echo("GET_ALL_HOUSES", null, new TypeReference<List<House>>() {},
                            res -> {
                                res.forEach(subscriber::onNext);
                                subscriber.onCompleted();
                            })
                    );
        }


}

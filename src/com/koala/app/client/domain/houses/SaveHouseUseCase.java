package com.koala.app.client.domain.houses;

import com.koala.app.client.data.house.House;
import com.koala.app.client.data.house.HousesRepository;
import com.koala.app.client.data.house.Location;
import com.koala.app.client.data.user.Identity;
import com.koala.app.client.domain.UseCase;
import rx.Observable;

import java.util.Map;

/**
 * Created by mrsfy on 13-Dec-16.
 */
class SaveHouseUseCase extends UseCase {

    private House house;


    public SaveHouseUseCase(Map<String, Object> p) {
        house = new House();

        House.HouseFeatures houseFeatures = new House.HouseFeatures();
        houseFeatures.setTitle((String) p.get("title"));
        houseFeatures.setAge((int) p.get("buildingAge"));

        houseFeatures.setSize(Integer.parseInt((String) p.get("size")));
        houseFeatures.setBathroomNumber((int) p.get("numberOfBathrooms"));
        houseFeatures.setFurnishedInfo((boolean) p.get("isFurnished"));
        houseFeatures.setRoomNumber((int) p.get("numberOfRooms"));
        houseFeatures.setPrice(Integer.parseInt((String) p.get("price")));
        houseFeatures.setCurrentFloor((int) p.get("currentFloor"));
        houseFeatures.setTotalFloor((int) p.get("totalFloor"));


        house.setLocation(new Location((double) (p.get("lat")), (double) (p.get("lng"))));
        house.setHouseType(House.Types.FOR_SALE);
        house.setSeller(Identity.getCurrentUser());
        house.setHouseFeatures(houseFeatures);
    }

    @Override
    protected Observable<Void> buildUseCaseObservable() {


        return HousesRepository.getInstance().save(house);
    }
}

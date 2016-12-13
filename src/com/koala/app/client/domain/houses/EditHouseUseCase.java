package com.koala.app.client.domain.houses;

import com.koala.app.client.data.house.House;

/**
 * Created by mrsfy on 13-Dec-16.
 */
public class EditHouseUseCase extends SaveHouseUseCase {
    public EditHouseUseCase(House house) {
        super(house);
    }
}

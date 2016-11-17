package com.koala.client.models.properties;

import com.koala.client.models.properties.features.HouseFeatures;
import com.koala.client.models.roles.User;
import com.koala.client.utils.UID;
import com.koala.client.utils.UIDTypes;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 10.11.2016.
 */
public class House {

    private UID uid;
    private User seller;
    private HouseTypes houseType;
    private HouseFeatures houseFeatures;

    public House(User seller, HouseTypes houseType, HouseFeatures houseFeatures){
        uid = new UID(UIDTypes.HOUSE);
        this.seller = seller;
        this.houseType = houseType;
        this.houseFeatures = houseFeatures;

    }

    public UID getUid() {
        return uid;
    }

    public void setUid(UID uid) {
        this.uid = uid;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public HouseTypes getHouseType() {
        return houseType;
    }

    public void setHouseType(HouseTypes houseType) {
        this.houseType = houseType;
    }

    public HouseFeatures getHouseFeatures() {
        return houseFeatures;
    }

    public void setHouseFeatures(HouseFeatures houseFeatures) {
        this.houseFeatures = houseFeatures;
    }
}

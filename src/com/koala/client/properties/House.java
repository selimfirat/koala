package com.koala.client.properties;

import com.koala.client.properties.features.HouseFeatures;
import com.koala.client.roles.Seller;
import com.koala.client.utils.UID;
import com.koala.client.utils.UIDController;
import com.koala.client.utils.UIDTypes;

import java.util.HashMap;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 10.11.2016.
 */
public abstract class House {

    private UID uid;
    private Seller seller;
    private HouseFeatures houseFeatures;

    public House(){
        uid = new UID(UIDTypes.HOUSE);
    }

    public UID getUid() {
        return uid;
    }

    public void setUid(UID uid) {
        this.uid = uid;
    }

    public HouseFeatures getHouseFeatures() {
        return houseFeatures;
    }

    public void setHouseFeatures(HouseFeatures houseFeatures) {
        this.houseFeatures = houseFeatures;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}

package com.koala.app.client.data.house;

import com.koala.app.client.data.user.User;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 10.11.2016.
 */
public class House {


    public enum Types {
        FOR_RENT,
        FOR_SALE
    }

    private class HouseFeatures {

        private int roomNumber;


        public int getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
        }
    }


    private final String id;
    private User seller;
    private House.Types houseType;
    private HouseFeatures houseFeatures;

    public House(String id, User seller, Types houseType, HouseFeatures houseFeatures){
        this.id = id;
        this.seller = seller;
        this.houseType = houseType;
        this.houseFeatures = houseFeatures;

    }
    public String getId() {
        return id;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public House.Types getHouseType() {
        return houseType;
    }

    public void setHouseType(House.Types houseType) {
        this.houseType = houseType;
    }

    public HouseFeatures getHouseFeatures() {
        return houseFeatures;
    }

    public void setHouseFeatures(HouseFeatures houseFeatures) {
        this.houseFeatures = houseFeatures;
    }
}

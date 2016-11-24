package com.koala.app.client.data.house;

import com.koala.app.client.data.user.UserEntity;

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


    private UserEntity seller;
    private House.Types houseType;
    private HouseFeatures houseFeatures;

    public House(UserEntity seller, House.Types houseType, HouseFeatures houseFeatures){
        this.seller = seller;
        this.houseType = houseType;
        this.houseFeatures = houseFeatures;

    }

    public UserEntity getSeller() {
        return seller;
    }

    public void setSeller(UserEntity seller) {
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

package com.koala.app.client.models;

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


    private User seller;
    private House.Types houseType;
    private HouseFeatures houseFeatures;

    public House(User seller, House.Types houseType, HouseFeatures houseFeatures){
        this.seller = seller;
        this.houseType = houseType;
        this.houseFeatures = houseFeatures;

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

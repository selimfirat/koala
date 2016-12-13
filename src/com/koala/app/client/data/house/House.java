package com.koala.app.client.data.house;

import com.koala.app.client.data.user.User;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 10.11.2016.
 */
public class House {


    private final String id;
    private User seller;
    private House.Types houseType;
    private Location location;
    private HouseFeatures houseFeatures;

    public enum Types {
        FOR_RENT,
        FOR_SALE

    }

    private class HouseFeatures {
        private String comments;
        private boolean furnished;
        private int bathroomNumber;
        private int currentFloor;
        private int totalFloor;
        private int price;
        private int ageOfBuilding;
        private int size;
        private int roomNumber;

        private String title;

        public void setComments(String comments) {
            this.comments = comments;
        }

        public String getComments() {
            return comments;
        }

        public void setFurnishedInfo(boolean furnished) {
            this.furnished = furnished;
        }

        public boolean getFurnishedInfo() {
            return furnished;
        }

        public void setBathroomNumber(int bathroomNumber) {
            this.bathroomNumber = bathroomNumber;
        }

        public int getBathroomNumber() {
            return bathroomNumber;
        }

        public void setCurrentFloor(int currentFloor) {
            this.currentFloor = currentFloor;
        }

        public int getCurrentFloor() {
            return currentFloor;
        }

        public void setTotalFloor(int totalFloor) {
            this.totalFloor = totalFloor;
        }

        public int getTotalFloor() {
            return totalFloor;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }

        public void setAge(int ageOfBuilding) {
            this.ageOfBuilding = ageOfBuilding;
        }

        public int getAge() {
            return ageOfBuilding;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }

        public void setRoomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
        }

        public int getRoomNumber() {
            return roomNumber;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }


    }

    public House(String id, User seller, Types houseType, HouseFeatures houseFeatures){
        this.id = id;
        this.seller = seller;
        this.houseType = houseType;
        this.houseFeatures = houseFeatures;

    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

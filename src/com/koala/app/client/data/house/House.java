package com.koala.app.client.data.house;

import com.koala.app.client.data.user.User;
import org.jongo.marshall.jackson.oid.MongoId;
import org.jongo.marshall.jackson.oid.MongoObjectId;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 10.11.2016.
 *House class is for model a house according to its properties
 */
public class House {


    //Instance Variables
    @MongoId
    private String id;

    private User seller;
    private House.Types houseType;
    private Location location;
    private HouseFeatures houseFeatures;

    public void setId(String id) {
        this.id = id;
    }

    public enum Types {
        FOR_RENT,
        FOR_SALE

    }

    public static class HouseFeatures {

        //Instance variables
        private String comments;

        /*isFurnished method to check whether the house is furnished or not
        *returns furnisned.
        */
        public boolean isFurnished() {
            return furnished;
        }

        /*setFurnished method to set the house current condition whether it is furnished or not
        *@param furnisned.
        */
        public void setFurnished(boolean furnished) {
            this.furnished = furnished;
        }

        /*getAgeOfBuilding method to get age of building value
        *returns ageOfBuilding.
        */
        public int getAgeOfBuilding() {
            return ageOfBuilding;
        }

        /*setAgeOfBuilding method to set age of building with a new value
        *@param ageOfBuilding
        */
        public void setAgeOfBuilding(int ageOfBuilding) {
            this.ageOfBuilding = ageOfBuilding;
        }
        //instance variables
        private int currentFloor;
        private int totalFloor;
        private int bathroomNumber;
        private boolean furnished;
        private int price;
        private int size;
        private int ageOfBuilding;
        private int roomNumber;

        public HouseFeatures() {
        }

        //instance variables
        private String title;
        
        //constructors
        public HouseFeatures(String title, int roomNumber, int ageOfBuilding, int size, int price, boolean furnished, int bathroomNumber, String comments) {
            this.title = title;
            this.roomNumber = roomNumber;
            this.ageOfBuilding = ageOfBuilding;
            this.size = size;
            this.price = price;
            this.furnished = furnished;
            this.bathroomNumber = bathroomNumber;
            this.comments = comments;
        }

        /*setComments method to set comments about that house
        *@param comments
        */
        public void setComments(String comments) {
            this.comments = comments;
        }

        /*getComment method to get comments about that house
        *returns comments.
        */
        public String getComments() {
            return comments;
        }

        /*setFurnishedInfo method for the house's current condition whether it is furnished or not
        *@param furnished
        */
        public void setFurnishedInfo(boolean furnished) {
            this.furnished = furnished;
        }

        /*getFurnishedInfo method to get house's current value whether it is furnished or not
        *returns ageOfBuilding.
         */
        public boolean getFurnishedInfo() {
            return furnished;
        }

        /*setBathroomNumber method to get how many bathroom does the house contains
        *@param bathroomNumber.
        */
        public void setBathroomNumber(int bathroomNumber) {
            this.bathroomNumber = bathroomNumber;
        }

        /*getBathroomNumber method to get how many bathroom does the house contains
        *returns getBathroomNumber.
        */
        public int getBathroomNumber() {
            return bathroomNumber;
        }

        /*setCurrentFloor method to set floor number of a house
        *@param currentFloor.
        */
        public void setCurrentFloor(int currentFloor) {
            this.currentFloor = currentFloor;
        }

        /*getCurrentFloor method to gave floor number of the house
        *returns currentFloor.
        */
        public int getCurrentFloor() {
            return currentFloor;
        }

        /*setTotalFloor method to set total floor number of a house
        *@param totalFloor.
        */
        public void setTotalFloor(int totalFloor) {
            this.totalFloor = totalFloor;
        }

        /*getTotalFloor method to get total floor number of a house
        *returns totalFloor.
        */
        public int getTotalFloor() {
            return totalFloor;
        }

       /*setPrice method to set price of the house
       *@param price.
       */
        public void setPrice(int price) {
            this.price = price;
        }

        /*getPrice method to get price of the house
       *returns price.
       */
        public int getPrice() {
            return price;
        }

       /*setAge method to set age of the house
       *@param ageOfBuilding.
       */
        public void setAge(int ageOfBuilding) {
            this.ageOfBuilding = ageOfBuilding;
        }
        /*getAge method to get age of the house
        *returns ageOfBuilding
        */
        public int getAge() {
            return ageOfBuilding;
        }
        /*setSize method to set size of the house
        *@param size
        */
        public void setSize(int size) {
            this.size = size;
        }
       /*getSize method to get age of the house
        *returns size
        */
        public int getSize() {
            return size;
        }
        /*setRoomNumber method to set room number of the house
        *@param roomNumber
        */
        public void setRoomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
        }
        /*getRoomNumber method to get room number of the house
        *returns roomNumber
        */
        public int getRoomNumber() {
            return roomNumber;
        }
         /*setTitle method to set title of the house
        *@param title
        */
        public void setTitle(String title) {
            this.title = title;
        }
        /*getTitle method to get title of the house
        *returns title
        */
        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return "HouseFeatures{" +
                    "comments='" + comments + '\'' +
                    ", currentFloor=" + currentFloor +
                    ", totalFloor=" + totalFloor +
                    ", bathroomNumber=" + bathroomNumber +
                    ", furnished=" + furnished +
                    ", price=" + price +
                    ", size=" + size +
                    ", ageOfBuilding=" + ageOfBuilding +
                    ", roomNumber=" + roomNumber +
                    ", title='" + title + '\'' +
                    '}';
        }
    }
    //constructors
    public House() {
    }

    public House(String id, User seller, Types houseType, HouseFeatures houseFeatures){
        this.id = id;
        this.seller = seller;
        this.houseType = houseType;
        this.houseFeatures = houseFeatures;

    }

   /*getLocation method to get location of the house
    *returns location
    */
    public Location getLocation() {
        return location;
    }
    /*setLocation method to set location of the house
    *@param location
    */
    public void setLocation(Location location) {
        this.location = location;
    }
    /*getId method to get Id of the house
    *returns id
    */
    public String getId() {
        return id;
    }
    /*getSeller method to get seller of the house
    *returns seller
    */
    public User getSeller() {
        return seller;
    }
    /*setSeller method to set seller of the house
    *@param seller
    */
    public void setSeller(User seller) {
        this.seller = seller;
    }
    /*getHouseType method to get type of the house
    *returns houseType
    */
    public House.Types getHouseType() {
        return houseType;
    }
    /*setHouseType method to set type of the house
    *@param houseType
    */
    public void setHouseType(House.Types houseType) {
        this.houseType = houseType;
    }
    /*getHouseFeatures method to get house features
    *returns houseType
    */
    public HouseFeatures getHouseFeatures() {
        return houseFeatures;
    }
    /*setHouseFeatures method to set house features
    *@param houseType
    */

    public void setHouseFeatures(HouseFeatures houseFeatures) {
        this.houseFeatures = houseFeatures;
    }

    @Override
    public String toString() {
        return "House{" +
                "id='" + id + '\'' +
                ", seller=" + seller +
                ", houseType=" + houseType +
                ", location=" + location +
                ", houseFeatures=" + houseFeatures +
                '}';
    }
}

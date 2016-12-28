package com.koala.app.client.models.house;

/**
 * Created by mrsfy on 13-Dec-16.
 */
public class Location {
    
    //instances variables
    private double longitude;
    private double latitude;
    
    //constructors
    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public Location() {
    }
    /*getLatitude method to get Latitude of location
    *returns latitude
    */
    public double getLatitude() {

        return latitude;
    }
    /*setLatitude method to set Latitude of location
    *@param latitude
    */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    /*getLongitude method to get longitude of location
    *returns longitude
    */
    public double getLongitude() {
        return longitude;
    }
    
    /*setLongitude method to set longitude of location
    *@param longitude
    */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    /*toString method for displaying location
    *returns location
    */
    public String toString() {
        return "Location{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}

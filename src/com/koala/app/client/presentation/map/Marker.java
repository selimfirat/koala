package com.koala.app.client.presentation.map;

import com.koala.app.client.data.house.House;

/**
 * Created by Burak Erkilic on 12.12.2016.
 */
public class Marker {

    //####################### Instance variables #######################
    private int id;
    private String title;
    private String context;
    private String imageLocation;
    private double lat, lng;
    private House house;
    //####################################################################

    //####################### Constructors ###############################
    // Default constructor
    public Marker(){
        this.id = -1;
        this.title = "Default Title";
        this.context = "Default description for the house.";
        this.imageLocation = null;
        this.lat = 0;
        this.lng = 0;
    }

    // Only location constructor
    public Marker(double lat, double lng){
        this.id = -1;
        this.title = "Default Title";
        this.context = "Default description for the house.";
        this.imageLocation = null;
        this.lat = lat;
        this.lng = lng;
    }

    // Full constructor
    public Marker(int id, String title, String context, String imageLocation, double lat, double lng) {
        this.id = id;
        this.title = title;
        this.context = context;
        this.imageLocation = imageLocation;
        this.lat = lat;
        this.lng = lng;
    }
    //####################################################################

    //####################### Getters and Setters ########################
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void setLocation(double lat, double lng){
        this.lat = lat;
        this.lng = lng;
    }
    //#####################################################################


    //####################### Object Definitions #######################
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Marker marker = (Marker) o;

        return id == marker.id;

    }
    @Override
    public int hashCode() {
        return id;
    }
    @Override
    public String toString() {
        return "Marker{" +
                "ID=" + id +
                ", Title='" + title + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
    //####################################################################
}

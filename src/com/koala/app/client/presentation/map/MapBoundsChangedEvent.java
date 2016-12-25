package com.koala.app.client.presentation.map;

import com.koala.app.client.data.house.Location;
import javafx.event.Event;

/**
 * Created by mrsfy on 18-Dec-16.
 */
public class MapBoundsChangedEvent extends Event {

    @Override
    public String toString() {
        return "MapBoundsChangedEvent{" +
                "northEast=" + northEast +
                ", southWest=" + southWest +
                ", center=" + center +
                '}';
    }

    private Location northEast;
    private Location southWest;
    private Location center;

    public MapBoundsChangedEvent(GoogleMap map, Location center, Location northEast, Location southWest) {
        super(map, Event.NULL_SOURCE_TARGET, Event.ANY);
        this.northEast = northEast;
        this.southWest = southWest;
        this.center = center;
    }

    public Location getCenter() {
        return center;
    }

    public void setCenter(Location center) {
        this.center = center;
    }

    public Location getNorthEast() {

        return northEast;
    }

    public void setNorthEast(Location northEast) {
        this.northEast = northEast;
    }

    public Location getSouthWest() {
        return southWest;
    }

    public void setSouthWest(Location southWest) {
        this.southWest = southWest;
    }
}

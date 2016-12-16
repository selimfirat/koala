package com.koala.app.client.presentation.map;

/**
 * Created by Burak Erkilic on 12.12.2016.
 */

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Screen;
import netscape.javascript.JSObject;

import java.util.ArrayList;

public class GoogleMap extends Parent {

    //####################### Instance variables #######################
    private JSObject doc;
    private EventHandler<MapEvent> onMapLatLngChanged;
    private WebView webView;
    private WebEngine webEngine;
    private boolean ready;
    private ArrayList<Marker> markers;
    //####################################################################

    /**
     * Constructor
     * Initiation of following methods
     * initMap() iniCommunication() getChildren().add(webView)
     */
    public GoogleMap() {
        initMap();
        initCommunication();
        Screen screen = Screen.getPrimary();
        webView.setPrefSize(screen.getBounds().getWidth(),screen.getBounds().getHeight() - 100);
        getChildren().add(webView); // Will be change as JavaFx Elements change
        setMapCenter(0, 0);
        //switchTerrain();
        switchRoadmap();
        markers = new ArrayList<Marker>();
        addMarker(new Marker());
        //removeMarker(markers.get(0));
    }

    /**
     * Initialize the Map
     * Creates a webview which is for calling google map from html.
     **/
    private void initMap()
    {
        ready = false;

        //####################### Initialize Web View #######################
        webView = new WebView();
        webEngine = webView.getEngine();
        webEngine.load(getClass().getResource("map.html").toExternalForm());
        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>()
        {
            @Override
            public void changed(final ObservableValue<? extends Worker.State> observableValue,
                                final Worker.State oldState,
                                final Worker.State newState)
            {
                if (newState == Worker.State.SUCCEEDED)
                {
                    ready = true;
                }
            }
        });
        //####################################################################

    }

    /**
     * Initialize Communication
     * Initialize communication between Java and Javascript
     * Define and send reference of this class
     * */
    private void initCommunication() {
        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>()
        {
            @Override
            public void changed(final ObservableValue<? extends Worker.State> observableValue,
                                final Worker.State oldState,
                                final Worker.State newState)
            {
                if (newState == Worker.State.SUCCEEDED)
                {
                    doc = (JSObject) webEngine.executeScript("window");
                    doc.setMember("app", GoogleMap.this); // Set app variable into Javascript code which is referring to this class
                }
            }
        });
    }

    /**
     * Invoke Javascript
     * Invoke javascript code in the our map view. Eval javascript.
     * @param jsCode javascript code
     * */
    private void invokeJS(final String jsCode) {
        if(ready) {
            // If initialize succeeded
            doc.eval(jsCode); // Add and run the script
        }
        else {
            // Check again, If everything is ok, eval the script
            webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>()
            {
                @Override
                public void changed(final ObservableValue<? extends Worker.State> observableValue,
                                    final Worker.State oldState,
                                    final Worker.State newState)
                {
                    if (newState == Worker.State.SUCCEEDED)
                    {
                        doc.eval(jsCode); // Add and run the script
                    }
                }
            });
        }
    }

    public void setOnMapLatLngChanged(EventHandler<MapEvent> eventHandler) {
        onMapLatLngChanged = eventHandler;
    }

    public void handle(double lat, double lng) {
        if(onMapLatLngChanged != null) {
            MapEvent event = new MapEvent(this, lat, lng);
            onMapLatLngChanged.handle(event);
        }
    }

    public void addMarker(Marker marker){
        markers.add(marker);
        invokeJS("createMarker(" + Integer.toString(marker.getId())+ ", \"" + marker.getTitle() + "\", \"" + marker.getContext() + "\", \"" + marker.getImageLocation() + "\", "
                + Double.toString(marker.getLat()) + ", " + Double.toString(marker.getLng()) + ")");
    }

    public void removeMarker(Marker marker){
        markers.remove(marker);
        invokeJS("removeMarker(" + marker.getId()+")");
    }

    public void setMarkerPosition(Marker marker, double lat, double lng) {
        marker.setLocation(lat,lng);
        String sLat = Double.toString(lat);
        String sLng = Double.toString(lng);
        invokeJS("setMarkerPosition(" + marker.getId()+ ", " + sLat + ", " + sLng + ");");
    }

    public void setMapCenter(double lat, double lng) {
        String sLat = Double.toString(lat);
        String sLng = Double.toString(lng);
        invokeJS("setMapCenter(" + sLat + ", " + sLng + ");");
    }

    public void switchSatellite() {
        invokeJS("switchSatellite()");
    }

    public void switchRoadmap() {
        invokeJS("switchRoadmap()");
    }

    public void switchHybrid() {
        invokeJS("switchHybrid()");
    }

    public void switchTerrain() {
        invokeJS("switchTerrain()");
    }

    public void startJumping() {
        invokeJS("startJumping()");
    }

    public void stopJumping() {
        invokeJS("stopJumping()");
    }

    public void setHeight(double h) {
        webView.setPrefHeight(h);
    }

    public void setWidth(double w) {
        webView.setPrefWidth(w);
    }

    public ReadOnlyDoubleProperty widthProperty() {
        return webView.widthProperty();
    }

}

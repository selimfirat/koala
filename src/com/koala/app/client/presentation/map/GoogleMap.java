package com.koala.app.client.presentation.map;

/**
 * Created by Burak Erkilic on 12.12.2016.
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.koala.app.client.EventBus;
import com.koala.app.client.EventType;
import com.koala.app.client.models.house.House;
import com.koala.app.client.models.house.Location;
import com.koala.app.client.models.user.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.Parent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Screen;
import netscape.javascript.JSObject;

import java.io.IOException;
import java.util.List;

public class GoogleMap extends Parent {

    //####################### Instance variables #######################
    private JSObject doc;
    private WebView webView;
    private WebEngine webEngine;
    private boolean ready;

    private ObjectMapper objectMapper;

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

        objectMapper = new ObjectMapper();
    }

    /**
     * Initialize the Map
     * Creates a webview which is for calling google map from html.
     **/
    private void initMap() {
        ready = false;

        //####################### Initialize Web View #######################
        webView = new WebView();
        webEngine = webView.getEngine();
        webEngine.load(getClass().getResource("web/map.html").toExternalForm());
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
                    doc.setMember("app",GoogleMap.this); // Set app variable into Javascript code which is referring to this class
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


    public void setMapCenter(double lat, double lng) {
        String sLat = Double.toString(lat);
        String sLng = Double.toString(lng);
        invokeJS("setMapCenter(" + sLat + ", " + sLng + ");");
    }

    public void initSellHouseProcess() {
        invokeJS("initSellHouseProcess()");
    }

    public void removeAllMarkers() {
        invokeJS("removeAllMarkers()");
    }

    public void addMapHouseMarker(House house) {

        String jsonHouse = null;
        try {
            jsonHouse = objectMapper.writeValueAsString(house);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        invokeJS("addHouseMapMarker(" + jsonHouse + ")");

    }

    public void handle(double swLat, double swLng, double neLat, double neLng, double centerLat, double centerLong) {
        Location sw = new Location(swLat, swLng);
        Location ne = new Location(neLat, neLng);
        System.out.println("Map bounds changed event");
        Location center = new Location(centerLat, centerLong);
        MapBoundsChangedEvent event = new MapBoundsChangedEvent(this, center, ne, sw);
        EventBus.trigger(EventType.MAP_BOUNDS_CHANGED, event);
    }

    public void error(String err) {
        System.out.println("JS Err:" + err);
    }

    public void handleSellHouseLocation(double lat, double lng) {
        EventBus.trigger(EventType.SELL_HOUSE_LOCATION_SELECTED, new MapClickEvent(this, lat, lng));
    }

    public void editHouse(String houseJson) {

        House house = null;

        try {
            house = objectMapper.readValue(houseJson, House.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        EventBus.trigger(EventType.EDIT_HOUSE_CLICKED, house);

    }

    public void removeHouse(String id) {
        EventBus.trigger(EventType.REMOVE_HOUSE_CLICKED, id);
    }

    public void openMyOwnProperties(List<House> houses) {
        String housesJson = null;
        try {
            housesJson = objectMapper.writeValueAsString(houses);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        invokeJS("openMyOwnProperties(" + housesJson + ")");
    }

    public void sendMessage(String toUserJson) {
        User user = null;

        try {
            user = objectMapper.readValue(toUserJson, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        EventBus.trigger(EventType.SEND_MESSAGE_CLICKED, user);
    };
}

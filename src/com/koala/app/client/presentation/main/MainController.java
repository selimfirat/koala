package com.koala.app.client.presentation.main;

import com.koala.app.client.EventBus;
import com.koala.app.client.EventType;
import com.koala.app.client.data.house.House;
import com.koala.app.client.domain.DefaultSubscriber;
import com.koala.app.client.domain.UseCase;
import com.koala.app.client.domain.authentication.LogoutUseCase;
import com.koala.app.client.domain.houses.*;
import com.koala.app.client.presentation.IController;
import com.koala.app.client.presentation.Progress;
import com.koala.app.client.presentation.StageUtils;
import com.koala.app.client.presentation.house_dialogs.EditHouseDialog;
import com.koala.app.client.presentation.map.GoogleMap;
import com.koala.app.client.presentation.map.MapClickEvent;
import com.koala.app.client.presentation.house_dialogs.SellHouseDialog;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.util.*;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 17.11.2016.
 */
public class MainController implements IController {

    @FXML
    private TopBar topBar;

    @FXML
    private BottomBar bottomBar;


    @FXML
    private GoogleMap Gmap;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Gmap.setMapCenter(39.876870, 32.747808);

        EventBus.toObservableFX(EventType.SELL_HOUSE_CLICKED).subscribe(new DefaultSubscriber<Object>() {
            @Override
            public void onNext(Object o) {
                Gmap.initSellHouseProcess();
            }
        });


        EventBus.toObservableFX(EventType.SELL_HOUSE_LOCATION_SELECTED).subscribe(new SellHouseSubscriber());
        EventBus.toObservableFX(EventType.EDIT_HOUSE_CLICKED).subscribe(new EditHouseSubscriber());
        EventBus.toObservableFX(EventType.REMOVE_HOUSE_CLICKED).subscribe(new RemoveHouseSubscriber());
        EventBus.toObservableFX(EventType.MY_OWN_PROPERTIES_CLICKED).subscribe(new MyOwnPropertiesSubscriber());

        UseCase mapHousesUseCase = new GetAllHousesUseCase();
        mapHousesUseCase.execute(new MapHousesSubscriber());

        EventBus.toObservableFX(EventType.LOGOUT_CLICKED).subscribe(new LogoutSubscriber());
    }


    private class MyOwnPropertiesSubscriber extends DefaultSubscriber<Object> {

        @Override
        public void onNext(Object o) {

            UseCase myOwnPropertiesUseCase = new MyOwnPropertiesUseCase();
            myOwnPropertiesUseCase.execute(new DefaultSubscriber<House>(){

                List<House> houses = new ArrayList<House>();

                @Override
                public void onCompleted() {
                    Progress.end();
                    Gmap.openMyOwnProperties(houses);
                }

                @Override
                public void onStart() {
                    Progress.start("Opening my own properties");
                }

                @Override
                public void onNext(House house) {
                    houses.add(house);
                    System.out.println(house);
                }
            });

        }
    }

    private class LogoutSubscriber extends DefaultSubscriber<Object> {

        @Override
        public void onNext(Object o) {
            LogoutUseCase logoutUseCase = new LogoutUseCase();
            logoutUseCase.execute(new DefaultSubscriber() {
                @Override
                public void onStart() {
                    Progress.start("Logging out...");
                }

                @Override
                public void onCompleted() {
                    Progress.end();
                }
            });
        }
    }

    private class MapHousesSubscriber extends DefaultSubscriber<House> {
            @Override
            public void onStart() {
                Gmap.removeAllMarkers();
            }

            @Override
            public void onNext(House house) {
                Gmap.addMapHouseMarker(house);
            }

    }

    private class EditHouseSubscriber extends DefaultSubscriber<Object> {

        @Override
        public void onNext(Object o) {
            House house = (House) o;

            Map<String, Object> defaults = new HashMap<>();

            House.HouseFeatures features = house.getHouseFeatures();

            defaults.put("id", house.getId());
            defaults.put("title", features.getTitle());
            defaults.put("buildingAge", features.getAgeOfBuilding());
            defaults.put("size", features.getSize());
            defaults.put("numberOfBathrooms", features.getBathroomNumber());
            defaults.put("numberOfRooms", features.getRoomNumber());
            defaults.put("isFurnished", features.isFurnished());
            defaults.put("price", features.getPrice());
            defaults.put("currentFloor", features.getCurrentFloor());
            defaults.put("totalFloor", features.getCurrentFloor());
            defaults.put("comments", features.getComments());

            EditHouseDialog editHouseDialog = new EditHouseDialog(StageUtils.getMainStage(), defaults);
            editHouseDialog.showAndWait().ifPresent(buttonType -> {

                if (buttonType == ButtonType.FINISH) {
                    Map<Object, Object> p = editHouseDialog.getProperties();
                    p.put("lat", house.getLocation().getLatitude());
                    p.put("lng", house.getLocation().getLongitude());

                    Map<String, Object> ps = (Map) p;

                    UseCase editHouseUseCase = new EditHouseUseCase(ps);

                    editHouseUseCase.execute(new DefaultSubscriber<Void>(){
                        @Override
                        public void onCompleted() {
                            UseCase mapHousesUseCase = new GetAllHousesUseCase();
                            mapHousesUseCase.execute(new MapHousesSubscriber());

                            Notifications.create()
                                    .title("Success")
                                    .text("House edited successfully!")
                                    .showInformation();
                        }
                    });

                }
            });
        }
    }

    private class SellHouseSubscriber extends DefaultSubscriber<Object> {
            @Override
            public void onNext(Object o) {
                MapClickEvent location = (MapClickEvent) o;
                SellHouseDialog sellHouseDialog = new SellHouseDialog(StageUtils.getMainStage());
                sellHouseDialog.showAndWait().ifPresent(buttonType -> {

                    if (buttonType == ButtonType.FINISH) {
                        Map<Object, Object> p = sellHouseDialog.getProperties();
                        p.put("lat", location.getLat());
                        p.put("lng", location.getLng());

                        Map<String, Object> ps = (Map) p;
                        System.out.println(ps);

                        UseCase sellHouseUseCase = new AddHouseUseCase(ps);

                        sellHouseUseCase.execute(new DefaultSubscriber<Void>() {
                            @Override
                            public void onCompleted() {
                                UseCase mapHousesUseCase = new GetAllHousesUseCase();
                                mapHousesUseCase.execute(new MapHousesSubscriber());
                            }
                        });

                    }
                });
            }
    }

    private class RemoveHouseSubscriber extends DefaultSubscriber<Object> {


        @Override
        public void onNext(Object object) {

            String id = (String) object;

            UseCase removeHouseUseCase = new RemoveHouseUseCase(id);

            removeHouseUseCase.execute(new DefaultSubscriber(){

                @Override
                public void onStart() {
                    Progress.start("Removing house...");
                }

                @Override
                public void onCompleted() {
                    UseCase mapHousesUseCase = new GetAllHousesUseCase();
                    mapHousesUseCase.execute(new MapHousesSubscriber());
                    Progress.end();

                    Notifications.create()
                            .title("Success")
                            .text("House removed successfully!")
                            .showInformation();
                }

            });



        }
    }
}
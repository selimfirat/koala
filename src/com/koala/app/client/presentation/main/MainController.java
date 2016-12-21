package com.koala.app.client.presentation.main;

import com.koala.app.client.EventBus;
import com.koala.app.client.EventType;
import com.koala.app.client.data.house.House;
import com.koala.app.client.domain.DefaultSubscriber;
import com.koala.app.client.domain.UseCase;
import com.koala.app.client.domain.houses.AddHouseUseCase;
import com.koala.app.client.domain.houses.MapHousesUseCase;
import com.koala.app.client.presentation.IController;
import com.koala.app.client.presentation.StageUtils;
import com.koala.app.client.presentation.map.GoogleMap;
import com.koala.app.client.presentation.map.MapClickEvent;
import com.koala.app.client.presentation.sell_house.SellHouseDialog;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import rx.Subscriber;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.Consumer;

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


    UseCase mapHousesUseCase = new MapHousesUseCase();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Gmap.setMapCenter(39.876870, 32.747808);

        EventBus.toObservable(EventType.SELL_HOUSE_CLICKED).subscribe(new DefaultSubscriber<Object>() {
            @Override
            public void onNext(Object o) {
                Gmap.initSellHouseProcess();
            }
        });


        EventBus.toObservable(EventType.SELL_HOUSE_LOCATION_SELECTED).subscribe(sellHouseSubscriber());



        mapHousesUseCase.execute(mapHousesSubscriber());

    }

    private Subscriber mapHousesSubscriber() {
        return new DefaultSubscriber<House>(){
            @Override
            public void onStart() {
                Gmap.removeAllMarkers();
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onNext(House house) {
                Gmap.addMapHouseMarker(house);
            }

        };
    }

    private DefaultSubscriber<Object> sellHouseSubscriber() {
        return new DefaultSubscriber<Object>(){
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

                        UseCase sellHouseUseCase = new AddHouseUseCase(ps);

                        sellHouseUseCase.execute(new DefaultSubscriber<Void>() {
                            @Override
                            public void onError(Throwable throwable) {
                                System.out.println(throwable.getMessage());
                            }

                            @Override
                            public void onCompleted() {
                                System.out.println("oley be");
                                mapHousesUseCase.execute(mapHousesSubscriber());
                            }
                        });


                    }
                });
            }
        };
    }


}
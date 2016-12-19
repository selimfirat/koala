package com.koala.app.client.presentation.main;

import com.koala.app.client.EventBus;
import com.koala.app.client.EventType;
import com.koala.app.client.domain.DefaultSubscriber;
import com.koala.app.client.domain.UseCase;
import com.koala.app.client.domain.houses.AddHouseUseCase;
import com.koala.app.client.presentation.IController;
import com.koala.app.client.presentation.StageUtils;
import com.koala.app.client.presentation.map.GoogleMap;
import com.koala.app.client.presentation.map.MapClickEvent;
import com.koala.app.client.presentation.sell_house.SellHouseDialog;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;

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

        // Gmap.addMarker(new Marker(39.876870,32.747808));
    }

    private DefaultSubscriber<Object> sellHouseSubscriber() {
        return new DefaultSubscriber<Object>(){
            @Override
            public void onNext(Object o) {
                MapClickEvent location = (MapClickEvent) o;
                SellHouseDialog sellHouseDialog = new SellHouseDialog(StageUtils.getMainStage());
                sellHouseDialog.showAndWait().ifPresent(new Consumer<ButtonType>() {
                    @Override
                    public void accept(ButtonType buttonType) {
                        if (buttonType == ButtonType.FINISH) {
                            Map<Object, Object> p = sellHouseDialog.getProperties();
                            p.put("lat", location.getLat());
                            p.put("lng", location.getLng());

                            UseCase sellHouseUseCase = new AddHouseUseCase(p);

                            sellHouseUseCase.execute(new DefaultSubscriber<Void>() {
                                @Override
                                public void onCompleted() {
                                    System.out.println("oley be");
                                }
                            });


                        }
                    }
                });
            }
        };
    }
}
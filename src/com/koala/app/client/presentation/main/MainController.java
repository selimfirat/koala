package com.koala.app.client.presentation.main;

import com.koala.app.client.data.house.House;
import com.koala.app.client.data.user.User;
import com.koala.app.client.presentation.IController;
import com.koala.app.client.presentation.login.LoginDialog;
import com.koala.app.client.presentation.map.GoogleMap;
import com.koala.app.client.presentation.map.Marker;
import com.koala.app.client.presentation.register.RegisterDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import static com.koala.app.client.data.house.House.Types.FOR_SALE;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 17.11.2016.
 */
public class MainController implements IController, Initializable {

    @FXML
    private Accordion importantsAccordion;

    @FXML
    private BorderPane rootBorderPane;

    @FXML
    public void openLoginDialog(ActionEvent event) {
        new LoginDialog().show();
    }

    @FXML
    public void openRegisterDialog(ActionEvent event) {
        new RegisterDialog().show();
    }

    @FXML
    public GoogleMap Gmap;

    @Override
    public void init() {
        //new houses to be added, approximately 5
        // House house1 = new House("firstHouseID", new User(), FOR_SALE, new HouseFeatures());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("It is working.");
        Gmap.setMapCenter(39.876870, 32.747808);
        Gmap.addMarker(new Marker(39.876870,32.747808));
    }
}

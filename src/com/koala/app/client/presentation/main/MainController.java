package com.koala.app.client.presentation.main;

import com.koala.app.client.presentation.IController;
import com.koala.app.client.presentation.map.GoogleMap;
import com.koala.app.client.presentation.map.Marker;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

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
        Gmap.addMarker(new Marker(39.876870,32.747808));
    }
}

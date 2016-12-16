package com.koala.app.client.presentation.message;
import com.koala.app.client.presentation.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by ozlem on 10.12.2016.
 */
public class MessageController implements IController{

    @FXML
    private ListView<?> contactListView;

    @FXML
    private TextArea messages;

    @FXML
    void onClickSend(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}


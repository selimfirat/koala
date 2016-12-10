package com.koala.app.client.presentation.message;
import com.koala.app.client.presentation.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

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
    public void init() {

    }
}


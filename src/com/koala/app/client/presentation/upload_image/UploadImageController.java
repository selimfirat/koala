package com.koala.app.client.presentation.upload_image;

/**
 * Created by mert on 10.12.2016.
 */
import com.koala.app.client.presentation.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class UploadImageController implements IController {

    @FXML
    private ImageView uploaded3;

    @FXML
    private ImageView uploaded2;

    @FXML
    private ImageView uploaded1;

    @FXML
    private ImageView uploaded6;

    @FXML
    private ImageView uploaded5;

    @FXML
    private ImageView uploaded4;

    @FXML
    void onAddNew(ActionEvent event) {

    }

    @FXML
    void onFinish(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
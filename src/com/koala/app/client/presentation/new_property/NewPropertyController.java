package com.koala.app.client.presentation.new_property;

/**
 * Created by mert on 10.12.2016.
 */
import com.koala.app.client.presentation.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewPropertyController implements IController{

    @FXML
    private TextField priceTF;

    @FXML
    private TextField roomsTF;

    @FXML
    private TextField ageTF;

    @FXML
    private TextField furnisedTF;

    @FXML
    private TextField bathroomsTF;

    @FXML
    private TextField titleTF;

    @FXML
    private TextField sizeTF;

    @FXML
    private TextField commentsTF;

    @FXML
    void onCancel(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onAddProperty(ActionEvent event) {

    }

    @FXML
    void onChooseImage(ActionEvent event) {

    }

    @Override
    public void init() {

    }
}

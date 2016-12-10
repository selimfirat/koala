package com.koala.app.client.presentation.register;

import com.koala.app.client.presentation.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController implements IController {

    @FXML
    private TextField passwordAgainTF;

    @FXML
    private TextField usernameTF;

    @FXML
    private TextField nameTF;

    @FXML
    private TextField emailTF;

    @FXML
    private TextField phoneNumberTF;

    @FXML
    private TextArea passwordTF;

    @FXML
    void onClickCreate(ActionEvent event) {

    }

    @FXML
    void onClickCancel(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    @FXML
    void d72d2d(ActionEvent event) {

    }

    @Override
    public void init() {

    }
}

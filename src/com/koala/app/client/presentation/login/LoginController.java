package com.koala.app.client.presentation.login;

import com.koala.app.client.data.user.User;
import com.koala.app.client.domain.DefaultSubscriber;
import com.koala.app.client.domain.SingleUseCase;
import com.koala.app.client.domain.UseCase;
import com.koala.app.client.domain.authentication.LoginUseCase;
import com.koala.app.client.presentation.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import rx.SingleSubscriber;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 17.11.2016.
 */
public class LoginController implements IController {

    @FXML
    private TextField usernameTF;

    @FXML
    private PasswordField passwordTF;

    private SingleUseCase loginUseCase;

    @Override
    public void init() {
        usernameTF.requestFocus();
    }

    @FXML
    public void onClickCancel(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onClickLogin(ActionEvent event) {
        String username = usernameTF.getText();
        String password = passwordTF.getText();
        System.out.println("Username: " + username + "\nPassword: " + password);

        loginUseCase = new LoginUseCase(username, password);

        loginUseCase.execute(new SingleSubscriber() {
            @Override
            public void onSuccess(Object o) {

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
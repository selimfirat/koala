package com.koala.app.client.presentation.authentication;

import com.koala.app.client.models.user.User;
import com.koala.app.client.domain.DefaultSubscriber;
import com.koala.app.client.domain.UseCase;
import com.koala.app.client.domain.authentication.LoginUseCase;
import com.koala.app.client.presentation.IController;
import com.koala.app.client.presentation.Progress;
import com.koala.app.client.presentation.StageUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 17.11.2016.
 */
public class LoginController implements IController {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameTF.requestFocus();
    }

    @FXML
    private TextField usernameTF;

    @FXML
    private PasswordField passwordTF;

    @FXML
    public void onClickCancel(ActionEvent event) {
        StageUtils.closeStage(event);
    }

    @FXML
    public void onClickLogin(ActionEvent event) {

        String username = usernameTF.getText();
        String password = passwordTF.getText();
        UseCase loginUseCase = new LoginUseCase(username, password);

        loginUseCase.execute(new DefaultSubscriber<User>() {

            @Override
            public void onStart() {
                Progress.start("Logging in...");
            }

            @Override
            public void onError(Throwable throwable) {
                // on error
                Progress.end();

                Notifications.create()
                        .title("Error during login")
                        .text("Wrong username or password!")
                        .showError();

                System.out.println(throwable);
            }

            @Override
            public void onNext(User user) {
                Progress.end();
                onClickCancel(event);
            }

        });

    }

}
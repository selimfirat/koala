package com.koala.app.client.presentation.register;

import com.koala.app.client.domain.DefaultSubscriber;
import com.koala.app.client.domain.UseCase;
import com.koala.app.client.domain.authentication.RegisterUseCase;
import com.koala.app.client.presentation.IController;
import com.koala.app.client.presentation.util.Progress;
import com.koala.app.client.presentation.util.StageUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements IController {

    @FXML
    private PasswordField passwordAgainTF;

    @FXML
    private TextField usernameTF;

    @FXML
    private TextField nameTF;

    @FXML
    private TextField emailTF;

    @FXML
    private TextField phoneNumberTF;

    @FXML
    private PasswordField passwordTF;


    @FXML
    void onClickCreate(ActionEvent event) {
        Progress.start("Creating account...");
        UseCase registerUseCase = new RegisterUseCase(
                nameTF.getText(),
                usernameTF.getText(),
                passwordTF.getText(),
                passwordAgainTF.getText(),
                phoneNumberTF.getText(),
                emailTF.getText()
        );

        registerUseCase.execute(new DefaultSubscriber<Void>() {

            @Override
            public void onCompleted() {
                // On success
                Progress.end();
                Notifications.create()
                        .title("Success")
                        .text("Account created successfully!")
                        .showInformation();
                onClickCancel(event);
            }

            @Override
            public void onError(Throwable throwable) {
                // on error
                Progress.end();

                Notifications.create()
                        .title("Error during registration")
                        .text(throwable.getMessage())
                        .showError();
            }
        });
    }

    @FXML
    void onClickCancel(ActionEvent event) {
        StageUtils.closeStage(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameTF.requestFocus();
    }
}

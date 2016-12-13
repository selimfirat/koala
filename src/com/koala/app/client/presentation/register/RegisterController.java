package com.koala.app.client.presentation.register;

import com.koala.app.client.domain.DefaultSubscriber;
import com.koala.app.client.domain.UseCase;
import com.koala.app.client.domain.authentication.RegisterUseCase;
import com.koala.app.client.presentation.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        UseCase registerUseCase = new RegisterUseCase(
                nameTF.getText(),
                usernameTF.getText(),
                passwordTF.getText(),
                phoneNumberTF.getText(),
                emailTF.getText()
        );

        registerUseCase.execute(new DefaultSubscriber<Void>() {

            @Override
            public void onCompleted() {
                // On success
                System.out.println("success");
            }

            @Override
            public void onError(Throwable throwable) {
                // on error
                System.out.println("error");
            }
        });
    }

    @FXML
    void onClickCancel(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    @Override
    public void init() {

    }
}

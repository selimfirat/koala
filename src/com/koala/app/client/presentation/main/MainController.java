package com.koala.app.client.presentation.main;

import com.koala.app.client.presentation.IController;
import com.koala.app.client.presentation.login.LoginDialog;
import com.koala.app.client.presentation.register.RegisterDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.layout.BorderPane;

import java.util.Locale;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 17.11.2016.
 */
public class MainController implements IController {

    @FXML
    private Accordion importantsAccordion;

    @FXML
    private BorderPane rootBorderPane;

    @FXML
    public void openLoginDialog(ActionEvent event) {
        new LoginDialog().show();
    }

    @FXML
    public void openRegisterDialog(ActionEvent event) {
        new RegisterDialog().show();
    }

    @Override
    public void init() {

    }
}

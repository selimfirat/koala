package com.koala.app.client.presentation;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Builder;
import javafx.util.BuilderFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 26.11.2016.
 */
public abstract class CustomDialog extends Stage implements Initializable {

    public CustomDialog(String dialogFile) {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("resources/" + dialogFile));

        // Nice to have this in a load() method instead of constructor, but this seems to be de-facto standard.
        try
        {
            setScene(new Scene(fxmlLoader.load()));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        setAlwaysOnTop(true);
        initStyle(StageStyle.UTILITY);
    }

    public CustomDialog(String dialogFile, String title) {
        this(dialogFile);
        setTitle(title);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

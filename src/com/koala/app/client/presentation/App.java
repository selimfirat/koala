package com.koala.app.client.presentation;
/*
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 22.11.2016.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.initStyle(StageStyle.UNDECORATED);

        Scene mainScene = getScene("main.fxml");

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        stage.setScene(mainScene);
        stage.show();
    }

    private Scene getScene(String sceneName) {

        Scene scene = null;
        try {
            scene = new Scene(FXMLLoader.load(App.class.getResource("resources/" + sceneName)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return scene;
    }
}

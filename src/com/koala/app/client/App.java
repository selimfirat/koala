package com.koala.app.client;
/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 22.11.2016.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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

        Scene mainWindow = getScene("main.fxml");
        stage.setScene(mainWindow);
        stage.show();
    }

    private Scene getScene(String fileName) {

        Scene scene = null;
        try {
            scene = new Scene(FXMLLoader.load(App.class.getResource("resources/" + fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scene;
    }
}

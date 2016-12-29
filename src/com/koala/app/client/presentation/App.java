package com.koala.app.client.presentation;
/*
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 22.11.2016.
 */

import com.koala.app.client.domain.SocketProvider;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.jongo.Jongo;

import java.io.IOException;

public class App extends Application {

    public static Jongo jongo;

    public static void main(String[] args) {
        jongo = new Jongo(new MongoClient(new MongoClientURI("mongodb://msg:123123@ds119618.mlab.com:19618/koala")).getDB("koala"));
        SocketProvider.getSocket();

        launch();
    }

    @Override
    public void start(Stage stage) {
        Scene mainScene = null;
        try {
            mainScene = new Scene(FXMLLoader.load(App.class.getResource("resources/main.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();


        StageUtils.setMainStage(stage);

        stage.initStyle(StageStyle.UNDECORATED);
        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        stage.setScene(mainScene);
        stage.show();
    }

}
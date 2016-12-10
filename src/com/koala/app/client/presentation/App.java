package com.koala.app.client.presentation;
/*
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 22.11.2016.
 */

import com.koala.app.client.data.house.HousesRepository;
import com.koala.app.client.data.user.UsersRepository;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.jongo.Jongo;

import java.io.IOException;

public class App extends Application {

    public static void main(String[] args) {

        Jongo jongo = new Jongo(new MongoClient(new MongoClientURI("mongodb://koala_user:koala123@ds119618.mlab.com:19618/koala")).getDB("koala"));
        UsersRepository.getInstance().setJongo(jongo);
        HousesRepository.getInstance().setJongo(jongo);

        launch();
    }

    @Override
    public void start(Stage stage) {
        Scene mainScene = null;
        try {
            mainScene = new Scene((Parent) FXMLLoader.load(App.class.getResource("resources/main.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }



        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        stage.initStyle(StageStyle.UNDECORATED);
        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        stage.setScene(mainScene);
        stage.show();
    }


}
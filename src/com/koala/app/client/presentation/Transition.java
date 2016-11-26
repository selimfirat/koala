package com.koala.app.client.presentation;

import com.koala.app.client.presentation.main.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 26.11.2016.
 */
public class Transition {

    private Map<String, Class<?>> controllerToFXML = new HashMap<>();
    private Stage mainStage;

    private static final String INITIAL_SCENE = "main";

    public Transition(Stage mainStage) {
        this.mainStage = mainStage;
        this.controllerToFXML.put("main", MainController.class);
        init();
    }

    private void init() {
        Scene scene = getScene(INITIAL_SCENE);

        mainStage.setScene(scene);
        mainStage.show();
    }

    private Scene getScene(String sceneName) {

        Scene scene = null;
        try {
            scene = new Scene(FXMLLoader.load(Transition.class.getResource("resources/" + sceneName + ".fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return scene;
    }
}

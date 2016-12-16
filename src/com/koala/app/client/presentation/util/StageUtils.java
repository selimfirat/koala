package com.koala.app.client.presentation.util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * Created by mrsfy on 16-Dec-16.
 */
public class StageUtils {

    public static void closeStage(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
}

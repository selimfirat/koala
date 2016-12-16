package com.koala.app.client.presentation;

import com.koala.app.client.presentation.main.BottomBar;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.stage.Screen;
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

    private static Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();


    public static double getStageWidth() {
        return screenBounds.getWidth();
    }
    public static double getStageHeight() {
        return screenBounds.getHeight();
    }

    public static double getStageMinX() {
        return screenBounds.getMinY();
    }
    public static double getStageMinY() {
        return screenBounds.getMinY();
    }

}

package com.koala.app.client.presentation.main;

import com.koala.app.client.presentation.StageUtils;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import org.controlsfx.control.StatusBar;

/**
 * Created by mrsfy on 16-Dec-16.
 */
public class BottomBar extends Parent {


    private static StatusBar statusBar;

    public BottomBar() {
        statusBar = new StatusBar();
        statusBar.setText("Happy Real Estate");

        statusBar.setPrefWidth(StageUtils.getStageWidth());
        statusBar.setPrefHeight(35);
        getChildren().add(statusBar);
    }

    private static Task<Void> task;

    public static void endProgress() {
        task.cancel();
    }

    public static void startProgress(String message) {
        task = new Task<Void>() {
            @Override protected Void call() throws Exception {
                updateMessage(message);

                Thread.sleep(50000);
                done();
                return null;
            }
        };

        statusBar.textProperty().bind(task.messageProperty());
        statusBar.progressProperty().bind(task.progressProperty());

        EventHandler<WorkerStateEvent> f = event -> {
            statusBar.textProperty().unbind();
            statusBar.progressProperty().unbind();
            statusBar.setText("Happy Real Estate");
            statusBar.setProgress(0);
        };

        task.setOnSucceeded(f);
        task.setOnCancelled(f);

        new Thread(task).start();
    }
}

package com.koala.app.client.presentation.main;

import com.koala.app.client.EventBus;
import com.koala.app.client.EventType;
import com.koala.app.client.models.user.Identity;
import com.koala.app.client.domain.DefaultSubscriber;
import com.koala.app.client.presentation.authentication.LoginDialog;
import com.koala.app.client.presentation.authentication.RegisterDialog;
import com.koala.app.client.presentation.StageUtils;
import com.koala.app.client.presentation.messaging.MessagesDialog;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.control.ToolBar;
import javafx.stage.Screen;
import org.controlsfx.control.action.Action;
import org.controlsfx.control.action.ActionGroup;
import org.controlsfx.control.action.ActionUtils;

import java.util.Arrays;
import java.util.Collection;

import static org.controlsfx.control.action.ActionUtils.ACTION_SEPARATOR;
import static org.controlsfx.control.action.ActionUtils.ACTION_SPAN;

/**
 * Created by mrsfy on 16-Dec-16.
 */
public class TopBar extends Parent {

    private ToolBar toolBar;

    private Collection<? extends Action> noAuthActions() {
        return Arrays.asList(                ACTION_SPAN,
                new Action("Login", e -> new LoginDialog().showAndWait()),
                ACTION_SEPARATOR,
                new Action("Register", e -> new RegisterDialog().showAndWait()),
                ACTION_SEPARATOR,
                new Action("Exit", (event) -> {
                    Platform.exit();
                    System.exit(0);
                })
        );
    }

    private Collection<? extends Action> authActions() {
        return Arrays.asList(
                ACTION_SPAN,
                new Action("Sell House", e -> EventBus.trigger(EventType.SELL_HOUSE_CLICKED)),
                ACTION_SEPARATOR,
                new Action("My Own Properties", e -> EventBus.trigger(EventType.MY_OWN_PROPERTIES_CLICKED)),
                ACTION_SEPARATOR,
                new Action("Messages", e -> new MessagesDialog().showAndWait()),
                ACTION_SEPARATOR,
                new Action("Logout", e -> EventBus.trigger(EventType.LOGOUT_CLICKED)),
                new Action("Exit", (event) -> {
                    Platform.exit();
                    System.exit(0);
                })
        );
    }

    public TopBar() {
        setToolbar();

        EventBus.toObservableFX(EventType.AUTH).subscribe(new DefaultSubscriber<Object>() {
            @Override
            public void onNext(Object o) {
                Platform.runLater(() -> {
                    getChildren().remove(toolBar);
                    setLayoutY(0);
                    setLayoutX(0);
                    toolBar = ActionUtils.updateToolBar(
                            toolBar,
                            Identity.isAuthenticated() ? authActions() : noAuthActions(),
                            ActionUtils.ActionTextBehavior.SHOW
                    );
                    getChildren().add(toolBar);

                });
            }
        });
    }

    private void setToolbar() {
        toolBar = ActionUtils.createToolBar(
                Identity.isAuthenticated() ? authActions() : noAuthActions(),
                ActionUtils.ActionTextBehavior.SHOW
        );

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        toolBar.setMinWidth(bounds.getWidth());
        toolBar.setMinHeight(30);
        getChildren().add(toolBar);
    }

}

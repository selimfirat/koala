package com.koala.app.client.presentation.main;

import com.koala.app.client.EventBus;
import com.koala.app.client.EventType;
import com.koala.app.client.models.user.Identity;
import com.koala.app.client.domain.DefaultSubscriber;
import com.koala.app.client.presentation.authentication.LoginDialog;
import com.koala.app.client.presentation.authentication.RegisterDialog;
import com.koala.app.client.presentation.StageUtils;
import com.koala.app.client.presentation.messaging.MessageDialog;
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
        return Arrays.asList(
                new ActionGroup("   File   ", new Action("Exit", StageUtils::closeStage)), // TODO: currently has a bug
                ACTION_SEPARATOR,
                ACTION_SPAN,
                new Action("Login", e -> new LoginDialog().showAndWait()),
                ACTION_SEPARATOR,
                new Action("Register", e -> new RegisterDialog().showAndWait())
        );
    }

    private Collection<? extends Action> authActions() {
        return Arrays.asList(
                new ActionGroup("   File   ", new Action("Exit", StageUtils::closeStage)), // TODO: currently has a bug
                ACTION_SPAN,
                new Action("Sell House", e -> EventBus.trigger(EventType.SELL_HOUSE_CLICKED)),
                ACTION_SEPARATOR,
                new Action("My Own Properties", e -> EventBus.trigger(EventType.MY_OWN_PROPERTIES_CLICKED)),
                ACTION_SEPARATOR,
                new Action("Favorites", e -> EventBus.trigger(EventType.FAVORITES_CLICKED)),
                ACTION_SEPARATOR,
                new Action("Messages", e -> new MessageDialog().showAndWait()),
                ACTION_SEPARATOR,
                new Action("Logout", e -> EventBus.trigger(EventType.LOGOUT_CLICKED))
        );
    }

    public TopBar() {
        setToolbar();

        EventBus.toObservableFX(EventType.AUTH).subscribe(new DefaultSubscriber<Object>() {
            @Override
            public void onNext(Object o) {
                getChildren().remove(toolBar);
                setLayoutY(0);
                setLayoutX(0);
                System.out.println("asadssa");
                toolBar = ActionUtils.updateToolBar(
                        toolBar,
                        Identity.isAuthenticated() ? authActions() : noAuthActions(),
                        ActionUtils.ActionTextBehavior.SHOW
                );
                getChildren().add(toolBar);
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

package com.koala.app.client.presentation.main;

import com.koala.app.client.EventBus;
import com.koala.app.client.EventType;
import com.koala.app.client.data.user.Identity;
import com.koala.app.client.domain.DefaultSubscriber;
import com.koala.app.client.domain.authentication.LogoutUseCase;
import com.koala.app.client.presentation.login.LoginDialog;
import com.koala.app.client.presentation.message.MessageDialog;
import com.koala.app.client.presentation.new_property.NewPropertyDialog;
import com.koala.app.client.presentation.register.RegisterDialog;
import com.koala.app.client.presentation.StageUtils;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
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
                new Action("Favorites", e -> EventBus.trigger(EventType.FAVORITES_CLICKED)),
                ACTION_SEPARATOR,
                new Action("Messages", e -> EventBus.trigger(EventType.MESSAGES_CLICKED)),
                ACTION_SEPARATOR,
                new Action("Logout", e -> new LogoutUseCase().execute(new DefaultSubscriber()))
        );
    }

    public TopBar() {
        setToolbar();

        EventBus.toObservable(EventType.AUTH).subscribe(new DefaultSubscriber<Object>() {
            @Override
            public void onNext(Object o) {
                getChildren().remove(toolBar);
                setLayoutY(0);
                setLayoutX(0);
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
        System.out.println(getLayoutBounds());
        toolBar = ActionUtils.createToolBar(
                !Identity.isAuthenticated() ? authActions() : noAuthActions(),
                ActionUtils.ActionTextBehavior.SHOW
        );

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        toolBar.setMinWidth(bounds.getWidth());
        toolBar.setMinHeight(30);
        getChildren().add(toolBar);
    }

}

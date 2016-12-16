package com.koala.app.client.presentation.main;

import com.koala.app.client.data.user.Identity;
import com.koala.app.client.presentation.login.LoginDialog;
import com.koala.app.client.presentation.message.MessageDialog;
import com.koala.app.client.presentation.register.RegisterDialog;
import com.koala.app.client.presentation.StageUtils;
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
                ACTION_SEPARATOR,
                ACTION_SPAN,
                new Action("Sell House", e -> new LoginDialog().showAndWait()),
                ACTION_SEPARATOR,
                new Action("Favorites", e -> new RegisterDialog().showAndWait()),
                ACTION_SEPARATOR,
                new Action("Messages", e -> new MessageDialog().showAndWait())
        );
    }


    public TopBar() {
        ToolBar toolBar =  ActionUtils.createToolBar(
                Identity.isAuthenticated() ? authActions() : noAuthActions(),
                ActionUtils.ActionTextBehavior.SHOW
        );

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        toolBar.setPrefWidth(bounds.getWidth());
        toolBar.setPrefHeight(30);


        getChildren().add(toolBar);
    }

}

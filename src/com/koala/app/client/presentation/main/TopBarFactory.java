package com.koala.app.client.presentation.main;

import com.koala.app.client.presentation.login.LoginDialog;
import com.koala.app.client.presentation.register.RegisterDialog;
import com.koala.app.client.presentation.util.StageUtils;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;
import org.controlsfx.control.action.ActionGroup;
import org.controlsfx.control.action.ActionUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;

import static org.controlsfx.control.action.ActionUtils.ACTION_SEPARATOR;
import static org.controlsfx.control.action.ActionUtils.ACTION_SPAN;

/**
 * Created by mrsfy on 16-Dec-16.
 */
public class TopBarFactory {

    private static Collection<? extends Action> actions;

    static {
        actions = Arrays.asList(
                new ActionGroup("Group 1", new Action("Action 1.1"),
                        new Action("Action 2.1")),
                ACTION_SEPARATOR,
                new ActionGroup("Group 2", new Action("Action 2.1"),
                        new ActionGroup("Action 2.2", new Action("Action 2.2.1"),
                                new Action("Action 2.2.2")),
                        new Action("Action 2.3")),
                ACTION_SPAN,
                new Action("Login", actionEvent -> {
                    new LoginDialog().showAndWait();
                }),
                ACTION_SEPARATOR,
                new Action("Register", actionEvent -> {
                    new RegisterDialog().showAndWait();
                }),
                ACTION_SEPARATOR,
                new Action("Exit", StageUtils::closeStage)
        );
    }

    public static ToolBar createToolBar() {
        return ActionUtils.createToolBar(actions, ActionUtils.ActionTextBehavior.SHOW);
    }
}

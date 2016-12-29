package com.koala.app.client.presentation.messaging;

import com.koala.app.client.models.user.User;
import com.koala.app.client.presentation.CustomDialog;

/**
 * Created by Asus-pc on 10.12.2016.
 */
public class MessagesDialog extends CustomDialog {


    public MessagesDialog() {
        super("message.fxml", "Messages");
    }
    public MessagesDialog(User user) {
        super("message.fxml", "Messages");

        fxmlLoader.
                <MessagesController>getController()
                .setInitialOpponent(user.getId());
        System.out.println(user);
    }
}
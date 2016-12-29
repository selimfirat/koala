package com.koala.app.client.presentation.messaging;

import com.koala.app.client.models.message.ChatSession;
import com.koala.app.client.models.message.Message;
import com.koala.app.client.models.user.Identity;
import com.koala.app.client.domain.DefaultSubscriber;
import com.koala.app.client.domain.UseCase;
import com.koala.app.client.domain.messaging.SendMessageUseCase;
import com.koala.app.client.models.user.User;
import com.koala.app.client.presentation.App;
import com.koala.app.client.presentation.IController;
import com.koala.app.client.presentation.Progress;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.controlsfx.control.Notifications;
import org.jongo.MongoCollection;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by ozlem on 10.12.2016.
 * Modified by Burak Erkilic on 24.12.2016.
 */
public class MessagesController implements IController{

    @FXML
    private ListView<String> contactListView;

    @FXML
    private TextArea messages;

    @FXML
    private TextArea messageSendBox; // Problematic

    private ArrayList<ChatSession> sessionList;
    private ChatSession currentSession;
    private SessionManager sessionManager;

    private String initialOpponent;


    @FXML
    void onClickSend(ActionEvent event) {
        Progress.start("Sending message...");
        UseCase sendMessageUseCase = new SendMessageUseCase(
                currentSession.getOpponent(), // get user from the session
                messageSendBox.getText()
        );

        sendMessageUseCase.execute(new DefaultSubscriber<Void>() {
            @Override
            public void onCompleted() {
                // On success
                Progress.end();
            }

            @Override
            public void onError(Throwable throwable) {
                // on error
                Progress.end();

                Notifications.create()
                        .title("Error during sending a message!")
                        .text(throwable.getMessage())
                        .showError();
            }
        });
        sessionList = sessionManager.getChatSessions();
        renderMessages();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sessionManager = new SessionManager(App.jongo);

        sessionList = sessionManager.getChatSessions();

        if (currentSession != null)
            renderMessages();

        setContactListView();

        contactListView.setOnMouseClicked(event -> {
            System.out.println("clicked on " + contactListView.getSelectionModel().getSelectedItem());
            for(ChatSession cs: sessionList){
                if(cs.getOpponent().equals(contactListView.getSelectionModel().getSelectedItem()) ){
                    changeCurrentSession(cs);
                    renderMessages();
                    return;
                }
            }
        });

        refresh();
    }

    public void refresh(){
        sessionList = sessionManager.getChatSessions();

        if (sessionList.size() > 0)
            changeCurrentSession(sessionList.get(0));

        setContactListView();
    }

    public void changeCurrentSession(ChatSession newSession){
        currentSession = newSession;
        renderMessages();
    }

    public void setContactListView(){
        ObservableList<String> data = FXCollections.observableArrayList();
        for(ChatSession cs: sessionList){
            data.add(cs.getOpponent());
        }
        contactListView.setItems(data);

    }

    public void renderMessages(){
        String result = "";
        messages.setText("");
        for(Message m: currentSession.getMessageList()){
            result += m.getFrom();
            result += "\n";
            result += m.getMessage();
            result += "\n\n";
        }
        messages.setText(result);
    }

    public void setInitialOpponent(String initialOpponent) {
        this.initialOpponent = initialOpponent;

        if ( sessionManager.getSessionByUser(initialOpponent) == null)
            sessionManager.addSessionWithUser(initialOpponent);

        changeCurrentSession(sessionManager.getSessionByUser(initialOpponent));

        renderMessages();
        setContactListView();
    }
}
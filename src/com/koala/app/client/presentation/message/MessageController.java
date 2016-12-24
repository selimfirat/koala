package com.koala.app.client.presentation.message;
import com.koala.app.client.data.message.ChatSession;
import com.koala.app.client.data.message.Message;
import com.koala.app.client.data.message.SessionManager;
import com.koala.app.client.data.user.Identity;
import com.koala.app.client.domain.DefaultSubscriber;
import com.koala.app.client.domain.UseCase;
import com.koala.app.client.domain.messaging.GetSentMessageUseCase;
import com.koala.app.client.domain.messaging.SendMessageUseCase;
import com.koala.app.client.presentation.IController;
import com.koala.app.client.presentation.Progress;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.Notifications;
import rx.Subscriber;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by ozlem on 10.12.2016.
 * Modified by Burak Erkilic on 24.12.2016.
 */
public class MessageController implements IController{

    @FXML
    private ListView<String> contactListView;

    @FXML
    private TextArea messages;

    @FXML
    private TextField messageSendBox; // Problematic

    private ArrayList<ChatSession> sessionList;
    private ChatSession currentSession;
    private SessionManager sessionManager;

    UseCase mapHousesUseCase = new GetSentMessageUseCase();

    @FXML
    void onClickSend(ActionEvent event) {
        Progress.start("Sending message...");
        UseCase sendMessageUseCase = new SendMessageUseCase(
                Identity.getCurrentUser(), // get user from the session
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
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sessionManager = new SessionManager();
        sessionList = sessionManager.getChatSessions();
        refresh();
        renderMessages();
        contactListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked on " + contactListView.getSelectionModel().getSelectedItem());
                for(ChatSession cs: sessionList){
                    if(cs.getOpponent().getFullName() == contactListView.getSelectionModel().getSelectedItem() ){
                        changeCurrentSession(cs);
                        renderMessages();
                        return;
                    }
                }
            }
        });

        refresh();
    }

    public void refresh(){
        sessionList = sessionManager.getChatSessions();
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
            data.add(cs.getOpponent().getFullName());
        }
        contactListView.setItems(data);
    }

    public void renderMessages(){
        String result = "";
        messages.setText("");
        for(Message m: currentSession.getMessageList()){
            result += m.getFrom().getFullName();
            result += "\n";
            result += m.getMessage();
            result += "\n\n";
        }
        messages.setText(result);
    }

}


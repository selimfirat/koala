package com.koala.app.client.presentation.messaging;

import com.koala.app.client.models.message.ChatSession;
import com.koala.app.client.models.message.Message;
import com.koala.app.client.models.user.Identity;
import com.koala.app.client.models.user.User;
import com.koala.app.client.domain.DefaultSubscriber;
import com.koala.app.client.domain.UseCase;
import com.koala.app.client.domain.messaging.GetMessagesUseCase;

import java.util.ArrayList;

/**
 * Created by BurakMac on 24.12.2016.
 */
public class SessionManager {

    private ArrayList<ChatSession> chatSessions;
    private ArrayList<Message> allMessages;

    public SessionManager() {
        chatSessions = new ArrayList<ChatSession>();

        UseCase getMessagesUseCase = new GetMessagesUseCase();

        getMessagesUseCase
                .execute(new GetMessagesSubscriber());

    }

    public void addSessionWithUser(User user) {
        chatSessions.add(new ChatSession(Identity.getCurrentUser(), user));
    }

    public ChatSession getSessionByUser(User user){
        for(ChatSession cs : chatSessions){
            if (cs.getOpponent().equals(user)){
                return cs;
            }
        }
        return null;
    }

    public ArrayList<ChatSession> getChatSessions(){
        setChatSessions();
        for(ChatSession cs : chatSessions)
            cs.sortMessages();
        return chatSessions;
    }

    public ArrayList<Message> getAllMessages(){
        return allMessages;
    }

    private void setChatSessions(){
        for(Message m : allMessages){
            ChatSession getCs = getSessionByUser(m.getFrom());
            if(getCs == null){
                ChatSession cs = new ChatSession(Identity.getCurrentUser(),m.getFrom()); // Problematic
                cs.addMessage(m);
                chatSessions.add(cs);
            } else {
                getCs.addMessage(m);
            }
        }
    }

    private class GetMessagesSubscriber extends DefaultSubscriber<Message> {

            @Override
            public void onStart() {
                allMessages = new ArrayList<Message>();
            }

            @Override
            public void onNext(Message message) {
                allMessages.add(message);
            }

        @Override
        public void onCompleted() {
            setChatSessions();
        }
    }

}
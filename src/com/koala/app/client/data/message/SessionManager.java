package com.koala.app.client.data.message;

import com.koala.app.client.data.user.Identity;
import com.koala.app.client.data.user.User;
import com.koala.app.client.domain.DefaultSubscriber;
import com.koala.app.client.domain.UseCase;
import com.koala.app.client.domain.messaging.GetReceivedMessageUseCase;
import com.koala.app.client.domain.messaging.GetSentMessageUseCase;
import rx.Subscriber;

import java.util.ArrayList;

/**
 * Created by BurakMac on 24.12.2016.
 */
public class SessionManager {

    private ArrayList<ChatSession> chatSessions;
    private ArrayList<Message> allMessages;
    private ArrayList<Message> received, sent;

    UseCase getReceivedMessageUseCase = new GetReceivedMessageUseCase();
    UseCase getSentMessageUseCase = new GetSentMessageUseCase();

    public SessionManager() {

        allMessages = new ArrayList<Message>();
        sent = new ArrayList<Message>();
        received = new ArrayList<Message>();

        getReceivedMessageUseCase.execute(GetReceivedMessageUseCase());
        getSentMessageUseCase.execute(GetSentMessageUseCase());

        setReceivedSessions();
        setSentSessions();
    }

    private ChatSession getSessionByUser(User user){
        for(ChatSession cs : chatSessions){
            if(cs.getOpponent().equals(user)){
                return cs;
            }
        }
        return null;
    }

    public ArrayList<ChatSession> getChatSessions(){
        setReceivedSessions();
        setSentSessions();
        for(ChatSession cs : chatSessions)
            cs.sortMessages();
        return chatSessions;
    }

    public ArrayList<Message> getAllMessages(){
        allMessages.addAll(sent);
        allMessages.addAll(received);
        return allMessages;
    }

    private void setReceivedSessions(){
        for(Message m : received){
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

    private void setSentSessions(){
        for(Message m : received){
            ChatSession getCs = getSessionByUser(m.getTo()); // Problematic
            if(getCs == null){
                ChatSession cs = new ChatSession(m.getTo(),m.getFrom()); // Problematic
                cs.addMessage(m);
                chatSessions.add(cs);
            } else {
                getCs.addMessage(m);
            }
        }
    }

    private Subscriber GetReceivedMessageUseCase() {
        return new DefaultSubscriber<Message>(){
            @Override
            public void onStart() {
                received = new ArrayList<Message>();
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onNext(Message message) {
                received.add(message);
            }
        };
    }

    private Subscriber GetSentMessageUseCase() {
        return new DefaultSubscriber<Message>(){
            @Override
            public void onStart() {
                sent = new ArrayList<Message>();
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onNext(Message message) {
                sent.add(message);
            }
        };
    }
}

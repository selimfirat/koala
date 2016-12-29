package com.koala.app.client.presentation.messaging;

import com.koala.app.client.models.message.ChatSession;
import com.koala.app.client.models.message.Message;
import com.koala.app.client.models.user.Identity;
import com.koala.app.client.models.user.User;
import com.koala.app.client.domain.DefaultSubscriber;
import com.koala.app.client.domain.UseCase;
import com.koala.app.client.domain.messaging.GetMessagesUseCase;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import java.util.ArrayList;

/**
 * Created by BurakMac on 24.12.2016.
 */
public class SessionManager {

    private ArrayList<ChatSession> chatSessions;
    private ArrayList<Message> allMessages;
    private Jongo jongo;
    private MongoCollection messages;

    public SessionManager(Jongo jongo) {
        allMessages = new ArrayList<Message>();
        chatSessions = new ArrayList<ChatSession>();
        this.jongo = jongo;
        messages = jongo.getCollection("messages");
    }

    public void addSessionWithUser(String user) {
        chatSessions.add(new ChatSession(Identity.getCurrentUser().getId(), user));
    }

    public ChatSession getSessionByUser(String user){
        for(ChatSession cs : chatSessions){
            if (cs.getOpponent().equals(user)){
                return cs;
            }
        }
        return null;
    }

    public void getMessagesFromDataBase(){
        MongoCursor<Message> messageCursor = messages.find("{ $or: [{from._id: #}, {to._id: #}]}", Identity.getCurrentUser().getId(), Identity.getCurrentUser().getId()).as(Message.class);
        while(messageCursor.hasNext()){
            allMessages.add(messageCursor.next());
        }
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
                ChatSession cs = new ChatSession(Identity.getCurrentUser().getId(),m.getFrom()); // Problematic
                cs.addMessage(m);
                chatSessions.add(cs);
            } else {
                getCs.addMessage(m);
            }
        }
    }


}
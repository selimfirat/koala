package com.koala.app.client.data.message;

import com.koala.app.client.data.user.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by BurakMac on 24.12.2016.
 */
public class ChatSession {

    private User me, opponent;
    private ArrayList<Message> messageList;

    public ChatSession(User me, User opponent) {
        this.me = me;
        this.opponent = opponent;
    }

    public ChatSession(User me, User opponent, ArrayList<Message> messageList) {
        this.me = me;
        this.opponent = opponent;
        this.messageList = messageList;
    }

    public void addMessage(Message msg){
        messageList.add(msg);
    }

    public void removeMessage(Message msg){
        messageList.remove(msg);
    }

    public void sortMessages(){
        Collections.sort(messageList, new Comparator<Message>() {
            public int compare(Message o1, Message o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
    }

    public User getMe() {
        return me;
    }

    public User getOpponent() {
        return opponent;
    }

    public ArrayList<Message> getMessageList(){
        return messageList;
    }

    public String printSession(){
        String result = "";
        for(Message m : messageList){
            System.out.println(m);
            result += m;
        }
        return result;
    }

}

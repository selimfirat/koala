package com.koala.app.client.models;


/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 10.11.2016.
 */
public class User {

    private static User _user;

    public static User getUser() {
        return _user;
    }

    public static void setUser(User user) {
        User._user = user;
    }



    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}

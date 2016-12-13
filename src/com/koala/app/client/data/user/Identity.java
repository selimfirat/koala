package com.koala.app.client.data.user;

/**
 * Created by mrsfy on 13-Dec-16.
 */

public class Identity {

    private static User currentUser = null;


    public static void logout() {
        setCurrentUser(null);
    }
    public static void setCurrentUser(User currentUser) {
        Identity.currentUser = currentUser;
    }

    public static User getCurrentUser() {
        return currentUser;
    }


    public static boolean isAuthenticated(){
        return currentUser != null;
    }

}

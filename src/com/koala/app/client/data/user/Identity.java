package com.koala.app.client.data.user;

/**
 * Created by mrsfy on 13-Dec-16.
 */

public class Identity {

    //constants
    private static User currentUser = null;


    //logout method
    public static void logout() {
        setCurrentUser(null);
    }
    
    //setCurrentUser method
    public static void setCurrentUser(User currentUser) {
        Identity.currentUser = currentUser;
    }

    //getCurrentUser method
    public static User getCurrentUser() {
        return currentUser;
    }


    //isAuthenticated method to determine if the current user is null or not
    public static boolean isAuthenticated(){
        return currentUser != null;
    }

}

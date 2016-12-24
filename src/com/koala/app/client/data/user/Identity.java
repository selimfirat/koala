package com.koala.app.client.data.user;

/**
 * Created by mrsfy on 13-Dec-16.
 */

public class Identity {

    //constants
    private static User currentUser = null;


    /*logout method to logout from app
     */
    public static void logout() {
        setCurrentUser(null);
    }
    
    /*setCurrentUser method to set the user
     *@param currentUser
     */
    public static void setCurrentUser(User currentUser) {
        Identity.currentUser = currentUser;
    }

    /*getCurrentUser method to get the user
     *returns currentUser
     */
    public static User getCurrentUser() {
        return currentUser;
    }


    /*isAuthenticated method to determine if there exists a user which uses the app
     *returns currentUser != null
     */
    public static boolean isAuthenticated(){
        return currentUser != null;
    }

}

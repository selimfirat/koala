package com.koala.app.client.data.user;

import org.jongo.marshall.jackson.oid.MongoId;
import org.jongo.marshall.jackson.oid.MongoObjectId;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 10.11.2016.
 */
public class User {

    //variables for user object
    @MongoId
    private String id;
    private String fullName;
    private String password;
    private String email;
    private String username;
    private String phoneNumber;

    /*User object with given parameters
     *@param id
     *@param fullName
     *@param password
     *@param email
     *@param username
     *@param phoneNumber
     */
    public User(String id, String fullName, String password, String email, String username, String phoneNumber) {
        this.id = id;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }

    //default constructor
    public User() {

    }

    /*getFullName method to get the fullname of the user
     *returns fullName
     */
    public String getFullName() {
        return fullName;
    }

    /*setFullName method to set the fullname of the user
     *@param fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /*getPassword method to get the password of the user
     *returns password
     */
    public String getPassword() {
        return password;
    }

    /*setPassword method to set the password of the user
     *@param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /*getEmail method to get the email of the user
     *returns email
     */
    public String getEmail() {
        return email;
    }

    /*setEmail method to set the email of the user
     *@param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /*getUserName method to get the username of the user
     *returns username
     */
    public String getUsername() {
        return username;
    }

    /*setUsername method to set the username of the user
     *@param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /*getPhoneNumber method to get the phone number of the user
     *returns phonNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /*setPhoneNumber method to set the phone number of the user
     *@param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /*getId method to get the id of the user
     *returns id
     */
    public String getId() {
        return id;
    }

    /*setId method to set the id of the user
     *@param id
     */
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

package com.koala.app.client.data.user;

import org.jongo.marshall.jackson.oid.MongoId;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 10.11.2016.
 */
public class User {

    @MongoId
    //variables for user object
    private String id;
    private String fullName;
    private String password;
    private String email;
    private String username;
    private String phoneNumber;

    //user object with parameters id, fullname, password, email, username, phoneNumber
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

    //getFullName method
    public String getFullName() {
        return fullName;
    }

    //setFullName method
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    //getPassword method
    public String getPassword() {
        return password;
    }

    //setPassword method
    public void setPassword(String password) {
        this.password = password;
    }

    //getEmail method
    public String getEmail() {
        return email;
    }

    //setEmail method
    public void setEmail(String email) {
        this.email = email;
    }

    //getUsername method
    public String getUsername() {
        return username;
    }

    //setUsername method
    public void setUsername(String username) {
        this.username = username;
    }

    //getPhoneNumber method
    public String getPhoneNumber() {
        return phoneNumber;
    }

    //setPhoneNumber method
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //getId method
    public String getId() {
        return id;
    }

    //setId method
    public void setId(String id) {
        this.id = id;
    }
}

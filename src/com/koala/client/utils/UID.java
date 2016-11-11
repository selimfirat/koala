package com.koala.client.utils;

/**
 * Author: Selim Fırat Yılmaz - mrsfy
 * Version: 1.0.0
 * Creation Date: 10.11.2016.
 */
public class UID {

    private long uid;

    public UID(UIDTypes t) {
        uid = UIDController.createUID(t);
    }


    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }
}

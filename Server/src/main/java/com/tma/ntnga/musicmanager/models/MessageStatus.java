package com.tma.ntnga.musicmanager.models;

import java.io.Serializable;

public enum MessageStatus implements Serializable{
    UPDATING("UPDATING"),
    UPDATED("UPDATED"),
    CREATING("CREATING"),
    CREATED("CREATED"),
    DELETED("DELETED");

    private String value;

    MessageStatus(String value) {
    }

}

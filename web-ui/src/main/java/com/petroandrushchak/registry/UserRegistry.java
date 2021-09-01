package com.petroandrushchak.registry;

import com.petroandrushchak.models.Agent;
import com.petroandrushchak.models.User;

public class UserRegistry {

    public static User getUser(){
        return new User("Petro");
    }

    public static Agent getAgent(){
        return new Agent();
    }
}

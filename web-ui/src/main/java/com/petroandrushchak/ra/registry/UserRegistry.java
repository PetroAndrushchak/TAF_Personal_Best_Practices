package com.petroandrushchak.ra.registry;

import com.petroandrushchak.ra.models.Agent;
import com.petroandrushchak.ra.models.User;

public class UserRegistry {

    public static User getUser(){
        return new User("petroandrushchak@gmail.com", "t5Gbj8YNY8HAs2F");
    }

    public static Agent getAgent(){
        return new Agent("petroandrushchak@gmail.com", "7wqM1$&j0*A1");
    }
}

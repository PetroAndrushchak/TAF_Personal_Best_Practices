package com.petroandrushchak.steps;

import com.petroandrushchak.models.User;
import io.qameta.allure.Step;

public class SignInSteps {

    @Step("Log in as a user {user} ")
    public void logInAsUser(User user){
        //throw new RuntimeException();
    }
}

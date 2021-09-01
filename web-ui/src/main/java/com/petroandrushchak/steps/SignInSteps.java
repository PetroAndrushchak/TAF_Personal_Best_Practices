package com.petroandrushchak.steps;

import com.petroandrushchak.models.User;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

@Component
public class SignInSteps {

    @Step("Log in as a user {user} ")
    public void logInAsUser(User user){
        //throw new RuntimeException();
    }
}

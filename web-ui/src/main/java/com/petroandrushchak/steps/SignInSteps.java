package com.petroandrushchak.steps;

import com.petroandrushchak.aop.RetryStep;
import com.petroandrushchak.models.Agent;
import com.petroandrushchak.models.User;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;

@Component
public class SignInSteps {

    @RetryStep
    @Step("Log in as a user {user} ")
    public void logInAsUser(User user){
        System.out.println("Log in console!!! As a User");
       // throw new RuntimeException();
    }

    @RetryStep
    @Step("Log in as an agent {agent} ")
    public void logInAsAgent(Agent agent){
        System.out.println("Log in console!!! Agent");
        throw new RuntimeException();
    }

}

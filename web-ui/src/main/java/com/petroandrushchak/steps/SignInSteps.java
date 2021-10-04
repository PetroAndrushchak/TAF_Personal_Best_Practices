package com.petroandrushchak.steps;

import com.petroandrushchak.aop.RetryStep;
import com.petroandrushchak.models.Agent;
import com.petroandrushchak.models.User;
import io.qameta.allure.Step;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

@Component
public class SignInSteps {

    @Step("Log in as a user {user} ")
    @Retryable
    @RetryStep
    public void logInAsUser(User user){
        System.out.println("Log in console!!!");
        throw new RuntimeException();
    }

    @Step("Log in as an agent {agent} ")
    public void logInAsAgent(Agent agent){
        System.out.println("Log in console!!!");
    }

}

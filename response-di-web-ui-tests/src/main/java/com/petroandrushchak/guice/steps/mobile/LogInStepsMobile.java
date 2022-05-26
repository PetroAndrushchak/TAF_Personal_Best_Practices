package com.petroandrushchak.guice.steps.mobile;

import com.petroandrushchak.guice.steps.LoginSteps;

public class LogInStepsMobile implements LoginSteps {

    @Override
    public void logIn(String username, String password) {
        System.out.println("Log in via Mobile");
    }
}

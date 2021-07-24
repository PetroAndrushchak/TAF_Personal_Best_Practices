package com.petroandrushchak.guice.steps.desktop;

import com.petroandrushchak.guice.steps.LoginSteps;

public class LogInStepsDesktop implements LoginSteps {

    @Override
    public void logIn(String username, String password) {
        System.out.println("Log in via desktop");
    }
}

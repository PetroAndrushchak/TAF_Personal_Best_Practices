package com.petroandrushchak.spring.steps;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("mobile")
@Component
public class MobileLoginSteps extends LoginSteps {

    @Override
    public void login() {
        System.out.println("Log in via Mobile view ");
    }
}

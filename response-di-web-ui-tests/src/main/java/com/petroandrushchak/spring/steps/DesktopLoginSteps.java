package com.petroandrushchak.spring.steps;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("desktop")
@Component
public class DesktopLoginSteps extends LoginSteps {
    @Override
    public void login() {
        System.out.println("Log in via Desktop view");
    }
}

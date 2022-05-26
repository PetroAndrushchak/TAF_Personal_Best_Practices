package com.petroandrushchak.ra.steps;

import com.petroandrushchak.ra.pages.HomePage;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SiteSteps {

    @Autowired
    HomePage homePage;

    @Step
    public void openHomePage(){
        homePage.open();
    }
}

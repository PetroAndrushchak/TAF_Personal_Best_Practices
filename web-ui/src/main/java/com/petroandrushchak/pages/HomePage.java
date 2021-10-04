package com.petroandrushchak.pages;

import com.codeborne.selenide.Selenide;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends BasePage{

    public void open() {
        Selenide.open("");
    }

}

package com.petroandrushchak.pear.space.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.petroandrushchak.config.BrowserManager;
import org.springframework.stereotype.Component;

@Component
public class HomePagePearSpace {

    Page page;

    Locator logInButton;

    public HomePagePearSpace() {
//        this.page = BrowserManager.getPage();
//        logInButton = page.locator("#header_link_signin");
    }

    public HomePagePearSpace openHomePage() {
        page.navigate("https://www.peerspace.com/");
        return this;
    }

    public void clickLogInButton() {
        logInButton.click();
    }
}

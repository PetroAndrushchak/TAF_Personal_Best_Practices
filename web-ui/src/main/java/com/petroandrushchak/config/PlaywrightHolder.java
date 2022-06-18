package com.petroandrushchak.config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import lombok.Getter;
import lombok.Setter;

public class PlaywrightHolder {

    @Getter
    Playwright playwright;

    @Getter
    Browser browser;

    @Setter
    @Getter
    BrowserContext browserContext;

    @Setter
    @Getter
    Page page;

    public PlaywrightHolder(Playwright playwright, Browser browser) {
        this.playwright = playwright;
        this.browser = browser;
    }

    public boolean isPagePresent() {
        return page != null;
    }

    public boolean isBrowserContextPresent() {
        return browserContext != null;
    }

    public void removePlaywright() {
        playwright = null;
        browser = null;
    }

    public void removeBrowserContext() {
        browserContext = null;
        page = null;
    }

}

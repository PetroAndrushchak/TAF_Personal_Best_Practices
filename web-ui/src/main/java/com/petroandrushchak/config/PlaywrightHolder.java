package com.petroandrushchak.config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightHolder {

    Playwright playwright;
    Browser browser;
    Page page;

    public PlaywrightHolder(Playwright playwright, Browser browser) {
        this.playwright = playwright;
        this.browser = browser;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public boolean isPagePresent() {
        return page != null;
    }
}

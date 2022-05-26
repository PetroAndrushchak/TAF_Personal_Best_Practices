package com.petroandrushchak.config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import lombok.Synchronized;

public class BrowserManager {

    private static ThreadLocal<PlaywrightHolder> playwrightThreadLocal = new ThreadLocal<>();

    public static void setUpPlaywright() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        playwrightThreadLocal.set(new PlaywrightHolder(playwright, browser));
    }

    @Synchronized
    public static Page getPage() {
        PlaywrightHolder playwrightHolder = playwrightThreadLocal.get();
        if (playwrightHolder.isPagePresent()) {
            return playwrightHolder.getPage();
        } else {
            Page page = playwrightHolder.browser.newPage();
            playwrightHolder.setPage(page);
            return page;
        }
    }

    public static void closeBrowser() {
        PlaywrightHolder playwrightHolder = playwrightThreadLocal.get();
        playwrightHolder.browser.close();
        playwrightHolder.playwright.close();
    }

    public static void closePage() {
        PlaywrightHolder playwrightHolder = playwrightThreadLocal.get();
        playwrightHolder.getPage().close();
    }

}

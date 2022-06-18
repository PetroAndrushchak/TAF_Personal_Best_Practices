package com.petroandrushchak.config;

import com.microsoft.playwright.*;
import lombok.Synchronized;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class BrowserManager {

    private static final ThreadLocal<PlaywrightHolder> playwrightThreadLocal = new ThreadLocal<>();

    @Synchronized
    public static Page getPage() {
        createPlaywrightIfNotCreated();

        PlaywrightHolder playwrightHolder = playwrightThreadLocal.get();
        if (!playwrightHolder.isBrowserContextPresent()) {
            BrowserContext browserContext = playwrightHolder.getBrowser().newContext();
            playwrightHolder.setBrowserContext(browserContext);

            Page page = browserContext.newPage();
            playwrightHolder.setPage(page);
            return page;
        } else {
            if (playwrightHolder.isPagePresent()) {
                return playwrightHolder.getPage();
            } else {
                Page page = playwrightHolder.getBrowserContext().newPage();
                playwrightHolder.setPage(page);
                return page;
            }
        }
    }

    private static void createPlaywrightIfNotCreated() {
        if (playwrightThreadLocal.get() == null) {
            Playwright playwright = Playwright.create();
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            playwrightThreadLocal.set(new PlaywrightHolder(playwright, browser));
        }
    }

    @Synchronized
    public static void closeBrowser() {
        PlaywrightHolder playwrightHolder = playwrightThreadLocal.get();
        playwrightHolder.getBrowserContext().close();
        playwrightHolder.removeBrowserContext();
    }

    @Synchronized
    public static void closePlaywright() {
        PlaywrightHolder playwrightHolder = playwrightThreadLocal.get();
        playwrightHolder.browser.close();
        playwrightHolder.playwright.close();
        playwrightThreadLocal.remove();
    }
}


package tests.pear.space;

import com.microsoft.playwright.*;
import com.petroandrushchak.config.BrowserManager;
import com.petroandrushchak.config.WebUITestsSpringConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WebUITestsSpringConfiguration.class)
public class BaseTest {

    static Playwright playwright;
    static Browser browser;

    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        BrowserManager.setUpPlaywright();
    }

    @BeforeEach
    void createContextAndPage() {
        BrowserManager.getPage();
    }

    @AfterEach
    void closeContext() {
        BrowserManager.closePage();
    }

    @AfterAll
    static void closeBrowser() {
        BrowserManager.closeBrowser();
    }
}

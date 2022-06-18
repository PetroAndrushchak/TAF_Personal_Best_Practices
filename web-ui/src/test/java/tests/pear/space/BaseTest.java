package tests.pear.space;

import com.microsoft.playwright.*;
import com.petroandrushchak.config.BrowserManager;
import com.petroandrushchak.config.WebUITestsSpringConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WebUITestsSpringConfiguration.class)
public class BaseTest {

    static Playwright playwright;
    static Browser browser;

    BrowserContext context;
    Page page;

    @AfterEach
    void closeBrowser() {
        log.info("AfterEach: Closing Browser");
        BrowserManager.closeBrowser();
    }

    @AfterAll
    static void closePlaywright() {
        log.info("AfterAll: Closing playwright");
        BrowserManager.closePlaywright();
    }
}

package com.petroandrushchak.driver;

import com.codeborne.selenide.Configuration;
import com.petroandrushchak.config.TestsConfigs;
import io.qameta.allure.Step;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class CustomWebDriverManager {


    @Step("Set up driver configuration ")
    public static void setUpDriverConfiguration(TestsConfigs configs) {

        if (configs.isRemoteSelenoidRun()) {
            log.info("Set up Selenoid Configuration");
            Configuration.pageLoadTimeout = 60000;
            Configuration.browserCapabilities.merge(getSelenoidDesiredCapabilities());
            Configuration.remote = "http://localhost:4444/wd/hub";
        } else {
            Configuration.headless = configs.headless();
        }

        Configuration.browser = configs.browser();
        // Configuration.browserSize = BrowserResolution.format(browserSize).getSize();
        // log.info("Browser size is: " + Configuration.browserSize);
        Configuration.browserPosition = "0x0";
        Configuration.baseUrl = configs.host();
        Configuration.timeout = 20000;

        //turn off taking screenshots automatically, screenshots are done via listeners
        Configuration.screenshots = false;

    }

    private static DesiredCapabilities getSelenoidDesiredCapabilities() {
        DesiredCapabilities options = new DesiredCapabilities();
        options.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true,
                "enableLog", true
        ));

        ChromeOptions optionsToFixRun = new ChromeOptions();
        optionsToFixRun.addArguments("--no-sandbox");
        optionsToFixRun.addArguments("--disable-gpu");
        optionsToFixRun.addArguments("--disable-dev-shm-usage");

        options.setCapability(ChromeOptions.CAPABILITY, optionsToFixRun);

        return options;
    }
}

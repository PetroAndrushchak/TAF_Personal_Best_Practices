package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.petroandrushchak.config.TestsConfigs;
import com.petroandrushchak.ra.driver.CustomWebDriverManager;
import com.petroandrushchak.ra.steps.SignInSteps;
import com.petroandrushchak.config.WebUITestsSpringConfiguration;
import com.petroandrushchak.ra.steps.SiteSteps;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URL;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WebUITestsSpringConfiguration.class)
public class TestBase {

//    @Autowired
//    protected SignInSteps signInSteps;

//    @Autowired
//    protected SiteSteps siteSteps;

    @Autowired
    protected TestsConfigs configs;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before All");
    }

    @SneakyThrows
    @BeforeEach
    public void beforeEach(TestInfo testInfo) {
       // Configuration.browser = "chrome";

       // CustomWebDriverManager.setUpDriverConfiguration(configs);
       // System.out.println("Before Each");

        // Selenium Hub configuration

        Configuration.timeout = 5000;
        Configuration.browserSize = "1920x1080";

        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.LINUX);
        var driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

        WebDriverRunner.setWebDriver(driver);

//        DesiredCapabilities capability = DesiredCapabilities.chrome();
//        capability.setBrowserName("chrome");
//        capability.setPlatform(Platform.MAC);
//        capability.setVersion("4");


//        Configuration.remote = "http://localhost:4444/wd/hub";
//
//        Configuration.browserCapabilities = Configuration.browserCapabilities.merge(capability);

    }

}

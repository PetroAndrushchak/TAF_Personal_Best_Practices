package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.codeborne.selenide.Configuration;
import com.petroandrushchak.config.TestsConfigs;
import com.petroandrushchak.ra.driver.CustomWebDriverManager;
import com.petroandrushchak.ra.steps.SignInSteps;
import com.petroandrushchak.config.WebUITestsSpringConfiguration;
import com.petroandrushchak.ra.steps.SiteSteps;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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

    @BeforeEach
    public void beforeEach(TestInfo testInfo) {
        Configuration.browser = "chrome";

       // CustomWebDriverManager.setUpDriverConfiguration(configs);
        System.out.println("Before Each");
    }

}

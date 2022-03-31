package tests.junit5;

import com.petroandrushchak.config.TestsConfigs;
import com.petroandrushchak.models.Agent;
import com.petroandrushchak.models.User;
import com.petroandrushchak.registry.UserRegistry;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DisplayName("Company")
public class C7777_LogInTest extends JUnit5BaseTest {

    @Autowired
    TestsConfigs testsConfiguration;

    @Epic("JIRA-111")
    @Story("JIRA-777")
    @Description("Test for simple log in flow")
    @Feature("Login")
    @Link("http://google.com")
    @Owner("Petro Andrushcahk")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("C777")
    @Tag("ui")
    @Tag("regression")
    @Test
    public void agentEmailWhenUserLeftListingComment() {
        Agent agent = UserRegistry.getAgent();
        User user = UserRegistry.getUser();

        signInSteps.logInAsUser(user);
        System.out.println(testsConfiguration.host());

    }

}

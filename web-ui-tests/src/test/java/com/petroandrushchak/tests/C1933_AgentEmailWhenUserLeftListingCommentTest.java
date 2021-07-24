package com.petroandrushchak.tests;

import com.petroandrushchak.models.Agent;
import com.petroandrushchak.models.User;
import com.petroandrushchak.registry.UserRegistry;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Email Notification")
public class C1933_AgentEmailWhenUserLeftListingCommentTest extends BaseTest {

    @Epic("JIRA-123")
    @Story("JIRA-456")
    @Description("hello")
    @Feature("Login")
    @Issue("BUG-23")
    @Link("http://google.com")
    @Owner("dmitry.buzdin")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("TMS-22")
    @Tag("fast")
    @Test
    public void agentEmailWhenUserLeftListingComment() {
        Agent agent = UserRegistry.getAgent();
        User user = UserRegistry.getUser();

        signInSteps.logInAsUser(user);

    }


}

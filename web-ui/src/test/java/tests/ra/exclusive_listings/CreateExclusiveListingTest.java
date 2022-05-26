package tests.ra.exclusive_listings;

import com.petroandrushchak.ra.models.Agent;
import com.petroandrushchak.ra.registry.UserRegistry;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static tests.metadata.Epic.EXCLUSIVE_LISTINGS;
import static tests.metadata.Feature.CREATE_EXCLUSIVE_LISTING;
import static tests.metadata.Owner.PETRO_ANDRUSHCHAK;
import static tests.metadata.Story.*;

@Epic(EXCLUSIVE_LISTINGS)
@Feature(CREATE_EXCLUSIVE_LISTING)
@Owner(PETRO_ANDRUSHCHAK)
@DisplayName(EXCLUSIVE_LISTINGS)
public class CreateExclusiveListingTest extends TestBase {

    @TmsLink("C777")
    @Tag("ui") @Tag("regression")
    @Story(AGENT_CREATE_EXCLUSIVE_LISTINGS)
    @Description("Creating Exclusive Listing by Agent")
    @DisplayName("Agent create Exclusive listing")
    @Test
    void agentCanCreateExclusiveListingTest()  {
        Agent agent = UserRegistry.getAgent();
      //  siteSteps.openHomePage();

        signInSteps.logInAsAgent(agent);
        System.out.println("create");
    }

    @TmsLink("C779")
    @Tag("mobile") @Tag("regression") @Tag("smoke")
    @Story(ADMIN_CREATE_EXCLUSIVE_LISTINGS)
    @Description("Creating Exclusive Listing by Admin")
    @DisplayName("Admin create Exclusive listing")
    @Test
    void adminCanCreateExclusiveListingTest() {
        Agent agent = UserRegistry.getAgent();
        //  siteSteps.openHomePage();
        signInSteps.logInAsAgent(agent);
        System.out.println("create admin");
    }

}

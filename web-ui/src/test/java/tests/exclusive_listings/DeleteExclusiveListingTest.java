package tests.exclusive_listings;

import com.petroandrushchak.models.Agent;
import com.petroandrushchak.registry.UserRegistry;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static tests.metadata.Epic.EXCLUSIVE_LISTINGS;
import static tests.metadata.Feature.CREATE_EXCLUSIVE_LISTING;
import static tests.metadata.Feature.DELETE_EXCLUSIVE_LISTING;
import static tests.metadata.Owner.PETRO_ANDRUSHCHAK;
import static tests.metadata.Story.AGENT_CREATE_EXCLUSIVE_LISTINGS;
import static tests.metadata.Story.AGENT_DELETE_EXCLUSIVE_LISTINGS;

@Epic(EXCLUSIVE_LISTINGS)
@Feature(DELETE_EXCLUSIVE_LISTING)
@Story(AGENT_DELETE_EXCLUSIVE_LISTINGS)
@Owner(PETRO_ANDRUSHCHAK)
@DisplayName(EXCLUSIVE_LISTINGS)
public class DeleteExclusiveListingTest extends TestBase {

    @TmsLink("C778")
    @Tag("ui") @Tag("regression") @Tag("smoke")
    @Description("Delete Exclusive Listing by Agent")
    @DisplayName(AGENT_DELETE_EXCLUSIVE_LISTINGS)
    @Test
    public void agentCanDeleteExclusiveListingTest() {
        Agent agent = UserRegistry.getAgent();

        //  siteSteps.openHomePage();
        signInSteps.logInAsAgent(agent);

        System.out.println("delete");
    }
}

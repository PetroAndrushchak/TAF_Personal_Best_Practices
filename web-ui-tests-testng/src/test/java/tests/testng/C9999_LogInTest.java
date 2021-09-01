package tests.testng;

import com.petroandrushchak.config.TestsConfigs;
import com.petroandrushchak.models.Agent;
import com.petroandrushchak.models.User;
import com.petroandrushchak.registry.UserRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class C9999_LogInTest extends TestNgBaseTest {

    @Autowired
    TestsConfigs testsConfiguration;

    @Test
    public void logInTest(){

        Agent agent = UserRegistry.getAgent();
        User user = UserRegistry.getUser();

        signInSteps.logInAsUser(user);
        System.out.println(testsConfiguration.host());

    }
}

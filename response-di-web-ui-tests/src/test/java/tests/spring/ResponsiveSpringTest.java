package tests.spring;

import com.petroandrushchak.spring.steps.LoginSteps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

//https://blog.scottlogic.com/2020/07/10/Spring-Profiles.html
@ActiveProfiles("mobile")
public class ResponsiveSpringTest extends BaseTest {

    @Autowired
    LoginSteps loginSteps;

    @Test
    public void test() {
        loginSteps.login();
        System.out.println("Test");
    }
}

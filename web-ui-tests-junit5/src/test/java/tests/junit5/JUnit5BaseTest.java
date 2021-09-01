package tests.junit5;

import com.petroandrushchak.steps.SignInSteps;
import com.petroandrushchak.config.WebUITestsSpringConfiguration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// @SpringJUnitConfig(TestConfig.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WebUITestsSpringConfiguration.class)
public class JUnit5BaseTest {

    @Autowired
    protected SignInSteps signInSteps;

    @BeforeAll
    public static void beforeTest(){
        System.out.println("Before All");
    }

    @BeforeEach
    public void beforeEach(TestInfo testInfo){
        System.out.println("Before Each");
    }


}

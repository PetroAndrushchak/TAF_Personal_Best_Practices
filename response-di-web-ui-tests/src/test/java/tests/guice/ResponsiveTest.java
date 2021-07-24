package tests.guice;

import com.google.inject.Inject;
import org.junit.jupiter.api.Test;
import com.petroandrushchak.guice.pageobjects.SimpleClass;
import com.petroandrushchak.guice.steps.LoginSteps;

public class ResponsiveTest extends BaseTest {

    @Inject private LoginSteps loginSteps;
    @Inject private SimpleClass simpleClass;

    @Test
    public void test() {
        loginSteps.logIn("", "");
        System.out.println("Test");
    }
}

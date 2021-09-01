package tests.testng;

import com.petroandrushchak.config.WebUITestsSpringConfiguration;
import com.petroandrushchak.steps.SignInSteps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = WebUITestsSpringConfiguration.class)
public class TestNgBaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected SignInSteps signInSteps;

    @BeforeTestMethod
    public static void beforeTestMethod(){
        System.out.println("Before test method");
    }

    @AfterTestMethod
    public void beforeEach(){
        System.out.println("After Test Method");
    }


}

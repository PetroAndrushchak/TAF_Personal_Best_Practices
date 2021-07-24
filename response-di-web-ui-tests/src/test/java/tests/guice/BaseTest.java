package tests.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import com.petroandrushchak.guice.steps.DIDesktopStepsModule;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    @BeforeAll
    public void init() {
        Injector injector = Guice.createInjector(new DIDesktopStepsModule());
        injector.injectMembers(this);
    }

}

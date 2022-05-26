package tests.pear.space;

import com.petroandrushchak.pear.space.page.HomePagePearSpace;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class LogInTest extends BaseTest {

    @Autowired
    HomePagePearSpace homePagePearSpace;

    @SneakyThrows
    @Test
    void logInTest() {
        homePagePearSpace.openHomePage()
                .clickLogInButton();

        Thread.sleep(10000);
    }

    @SneakyThrows
    @Test
    void logInTestSecond() {
        homePagePearSpace.openHomePage()
                .clickLogInButton();

        Thread.sleep(10000);
    }
}

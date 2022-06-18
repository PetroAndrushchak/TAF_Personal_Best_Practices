package tests.ra.exclusive_listings;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SimpleTest extends TestBase {

    @Test
    void testOpenPS() throws InterruptedException, FileNotFoundException {
        Thread.sleep(300000);
        Selenide.open("https://alpha.peerspaceapp.com");
        Thread.sleep(10000);
        File screenshot = Screenshots.takeScreenShotAsFile();
        Allure.addAttachment("Last Screen before browser close", new FileInputStream(screenshot));
    }
}

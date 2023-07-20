package tests.ra.exclusive_listings;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SimpleTest {

    @Test
    void testOpenPS() throws InterruptedException, FileNotFoundException {

        Selenide.open("https://www.realtyaustin.com/");
       // Thread.sleep(30000);
        File screenshot = Screenshots.takeScreenShotAsFile();
        Allure.addAttachment("Last Screen before browser close", new FileInputStream(screenshot));
    }
}

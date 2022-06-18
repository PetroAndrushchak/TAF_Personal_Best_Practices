package com.petroandrushchak.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FirstAppiumTest extends Base {

    public static void main(String[] args) throws MalformedURLException {

        var driver = getDriver();

        String sessionID = driver.getSessionId().toString();

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Preference']"))
              .click();

        var result = driver.findElementsByAndroidUIAutomator("clickable(true)");
        // driver.findElementByAndroidUIAutomator("text(\"3. Preference dependencies\")").click();

        System.out.println("sdfdsf");
    }
}

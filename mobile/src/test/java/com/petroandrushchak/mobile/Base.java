package com.petroandrushchak.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Base {

    @SneakyThrows
    public static AndroidDriver<AndroidElement> getDriver() {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "PetroTestDevice");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");//new step
        cap.setCapability(MobileCapabilityType.APP, "/Users/pandrushchak.appwell/Workspace/Peerspace/mobile/android/app/build/outputs/apk/alpha/debug/app-alpha-debug.apk");

        return new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
    }


    private static String resourcePath(String file) {
        URL resource = Thread.currentThread().getContextClassLoader().getResource(file);
        assertNotNull(resource, "Resource not found in classpath: " + file);
        return resource.getFile();
    }
}

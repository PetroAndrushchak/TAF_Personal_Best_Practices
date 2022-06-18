package com.petroandrushchak.mobile.utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Utils {

    public static void scrollToText(AndroidDriver<? extends MobileElement> driver, String text) {
        MobileElement el = driver.findElementByAndroidUIAutomator("new UiScrollable("
                + "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().text(\"" + text + "\"));");
    }
}

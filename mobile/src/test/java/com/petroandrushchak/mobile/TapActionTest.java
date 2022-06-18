package com.petroandrushchak.mobile;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.time.Duration;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class TapActionTest extends Base {

    public static void main(String[] args) {

        var driver = getDriver();

        driver.findElementByXPath("//android.widget.TextView[@content-desc='Views']").click();

        var element = driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]");

        TouchAction tapOptions = new TouchAction(driver);
        tapOptions.tap(tapOptions().withElement(element(element))).perform();

        driver.findElementByXPath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]").click();

        var peopleNameElement = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ExpandableListView/android.widget.TextView[1]");

       // tapOptions.longPress(LongPressOptions.longPressOptions().withElement(element(peopleNameElement)).withDuration(Duration.ofSeconds(2))).release().perform();


        System.out.println("dsfsdf");
    }
}

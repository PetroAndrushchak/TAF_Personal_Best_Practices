package com.petroandrushchak.mobile;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;

import java.time.Duration;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class SwipeActionTest extends Base {

    public static void main(String[] args) {

        var driver = getDriver();
        driver.findElementByXPath("//android.widget.TextView[@content-desc='Views']").click();
        driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
        driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
        driver.findElementByXPath("//*[@content-desc = '9']").click();

        TouchAction touchAction = new TouchAction(driver);

        var element = driver.findElementByXPath("//*[@content-desc = '15']");
        var secondElement = driver.findElementByXPath("//*[@content-desc = '45']");
        touchAction.longPress(
                           longPressOptions().withElement(element(element)).withDuration(Duration.ofSeconds(2)))
                   .moveTo(element(secondElement))
                   .release().perform();


        System.out.println("sdfsdf");


    }
}

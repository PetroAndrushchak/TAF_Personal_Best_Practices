package com.petroandrushchak.mobile;

import io.appium.java_client.TouchAction;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class DragAndDropActionTest extends Base {

    public static void main(String[] args) {

        var driver = getDriver();
        driver.findElementByXPath("//android.widget.TextView[@content-desc='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@content-desc='Drag and Drop']").click();

        var source = driver.findElementsByClassName("android.view.View").get(0);
        var dest = driver.findElementsByClassName("android.view.View").get(1);

        var touchAction = new TouchAction<>(driver);
        touchAction.longPress(element(source)).moveTo(element(dest)).release().perform();


        System.out.println("dsfsdf");
    }
}

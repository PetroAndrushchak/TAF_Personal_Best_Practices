package com.petroandrushchak.mobile;

import com.petroandrushchak.mobile.utils.Utils;

public class ScrollActionTest extends Base {

    public static void main(String[] args) {

        var driver = getDriver();
        driver.findElementByXPath("//android.widget.TextView[@content-desc='Views']").click();

        Utils.scrollToText(driver, "WebView");

        System.out.println("Test");
    }
}

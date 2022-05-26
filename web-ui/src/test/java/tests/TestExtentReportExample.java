package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TestExtentReportExample extends TestBase {

    @Test
    void testOne() {
        ExtentTest extentTest = extentReports.createTest("MyFirstTest");
        extentTest.assignCategory("Category One");
        extentTest.log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
        ExtentTest extentTest1 = extentTest.createNode("Test Node");
        extentTest1.createNode("dsfdsf");
        System.out.println("sdfsdf");
    }


    @Test
    void testTwo() {
        extentReports.createTest("MySecondTest")
                .log(Status.PASS, "This is a logging event for MySecondTest, and it passed!");
        System.out.println("dsfsdf");
    }
}

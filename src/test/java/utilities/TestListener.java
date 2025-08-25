package utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;
import base.BaseTest;
import org.openqa.selenium.WebDriver;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).driver; // Access protected WebDriver from BaseTest

        String testName = result.getName();
        ScreenshotUtil.takeScreenshot(driver, testName);
    }
}

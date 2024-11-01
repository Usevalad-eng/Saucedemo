package tests.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.utils.AllureUtils;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.printf("Test %s started  %n", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.printf("Test  %s success %n", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        AllureUtils.takeScreenshot(driver);
        System.out.printf("Test  %s failed %n", result.getName());
    }
}

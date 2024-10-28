package tests;

import org.testng.ITestListener;
import org.testng.*;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        //System.out.printf("Test started %s %n", result.getTestName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        //System.out.printf("Test  %s success %n", result.getTestName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        //System.out.printf("Test  %s failed %n", result.getTestName());
    }
}

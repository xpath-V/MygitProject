package com.tcs.greenKart;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
//import org.testng.asserts.SoftAssert;

public class TestListener implements ITestListener{
	
	public void captureScreenshot(ITestResult result, String status) {
		NewTopicListener testClass = (NewTopicListener) result.getInstance();
        TakesScreenshot ts = (TakesScreenshot) testClass.driver;
//        SoftAssert sAssert = new SoftAssert();

        File src = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(
                src,
                new File("screenshots/" + result.getName() + "_" + status + ".png")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	 captureScreenshot(result, "PASS");
        System.out.println("Test Passed: " + result.getName());
        
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	captureScreenshot(result, "FAIL");
        System.out.println("Test Failed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	captureScreenshot(result, "SKIP");
        System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Suite Finished: " + context.getName());
    }

}

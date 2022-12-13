package com.unlimit.listeners;

import com.unlimit.utils.Config;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;
import org.testng.asserts.SoftAssert;
import org.testng.internal.TestResult;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestNGListeners implements ITestListener, IInvokedMethodListener {
    private static Date startDate = new Date();
    private static File screenshotPath = new File(System.getProperty("user.dir") + "/src/main/resources" + File.separator
            + "screenshots" + File.separator + new Date() + ".png");
    SoftAssert softAssert = new SoftAssert();
    private Config config = new Config();
    private Object ITestContext;

    /**
     * <h2>onStart Method</h2> <B>Main purpose of this method is to check internet
     * connection and jdk is installed in the system or not and give automation
     * start date and time.</B>
     */

    @Override
    public void onStart(ITestContext arg0) {
// check Internet Connection (terminate the suite if Internet is not
// connected on machine)
        config.log.info("Running before suite......");
        boolean isInternetConnected = config.isNetAvailable();
        if (isInternetConnected) {
            Reporter.log("Internet connection is fine...", true);
            if (System.getProperty("java.version").contains("1.")) {
                config.log.info("JDK is installed in your System & Java Version is - "
                        + System.getProperty("java.version"));
            } else {
                config.fail("JDK is not installed in your System");
            }
        } else {
            Reporter.log("Internet is not connected....", true);
            Reporter.log("Hence... terminating the suite", true);
            onFinish((org.testng.ITestContext) ITestContext);
        }
        String message = "Automation Execution started on " + startDate + " on Thread id:- "
                + Thread.currentThread().getId();

        config.log.info(message);
        message = "<font style=\"color:green\">" + message + "</font></br>";
        Reporter.log(message, true);
    }

    /**
     * <h2>onFinish Method</h2> <B>Main purpose of this method is to give how much
     * time automation suite taking to run whole whole suite in seconds.</B>
     */

    @Override
    public void onFinish(ITestContext arg0) {
        DateFormat dateFormat = new SimpleDateFormat();
        Date endDate = new Date();
        double diff = (endDate.getTime() - startDate.getTime()) / 60000.00;
        String message = "";
        if (diff < 1)
            message = "Automation Execution finished after :- " + (endDate.getTime() - startDate.getTime()) / 1000.00
                    + " seconds. At " + dateFormat.format(endDate) + " on Thread id:- "
                    + Thread.currentThread().getId();
        else
            message = "Automation Execution finished after :- " + diff + " minutes. At " + dateFormat.format(endDate)
                    + " on Thread id:- " + Thread.currentThread().getId();

        config.log.info(message);
        message = "<font style=\"color:green\">" + message + "</font></br>";
        Reporter.log(message, true);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult testResult) {
    }

    /**
     * <h2>onTestFailure Method</h2> <B>Main purpose of this method is to give how
     * much time automation suite taking to run whole whole suite in seconds.</B>
     */

    @Override
    public void onTestFailure(ITestResult testResult) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) config.driver;
            File SrcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File DestFile = new File(String.valueOf(screenshotPath));
            FileUtils.copyFile(SrcFile, DestFile);
            String encodstring = config.encodeFileToBase64Binary(screenshotPath);
            Reporter.log("<b>Please refer screenshot - </b></ br><img src='data:image/png;base64," + encodstring
                    + "'></img></br>", false);
        } catch (Exception e) {
            config.fail(ExceptionUtils.getStackTrace(e));
        } finally {
            Reporter.log("***************EXECUTION OF TESTCASE ENDS HERE at : "
                    + new Date() + " ***************", true);
        }
    }

    /**
     * <h2>onTestSkipped Method</h2> <B>Main purpose of this method is to give user
     * a information that test cases are skipped.</B>
     */

    @Override
    public void onTestSkipped(ITestResult testResult) {
        String message = "Test case skipped - '" + testResult.getName() + "'";
        config.log.info(message);
        message = "<font style=\"color:orange\">" + message + "</font></br>";
        Reporter.log(message, true);

    }

    /**
     * <h2>onTestStart Method</h2> <B>Main purpose of this method is to give user a
     * information that test cases are now started at particular date and time.</B>
     */

    @Override
    public void onTestStart(ITestResult testResult) {
        Reporter.setCurrentTestResult(testResult);
        List<String> reporterOutput = Reporter.getOutput(testResult);
        Reporter.log("<B>Test '" + testResult.getName() + "' Started on '" + startDate + "'</B>", true);
    }

    /**
     * <h2>onTestSuccess Method</h2> <B>Main purpose of this method is to give user
     * a information of test case is passed and successed at particular date and
     * time</B>
     */

    @Override
    public void onTestSuccess(ITestResult testResult) {
        Reporter.setCurrentTestResult(testResult);
        List<String> reporterOutput = Reporter.getOutput(testResult);
        DateFormat dateFormat = new SimpleDateFormat();
        Date endDate = new Date();
        Reporter.log("<B>Test '" + testResult.getName() + "' Passed on '" + dateFormat.format(endDate) + "'</B>", true);
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
    }

    /**
     * <h2>afterInvocation Method</h2> <B>Main purpose of this method is to give
     * user a information before test method is now starts running.</B>
     */

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
// Run this after running a test case which failed with soft asserts (Log.Fail)
// i.e. status as success,
// to do assertAll, and mark the test case as fail
        if (method.isTestMethod() && testResult.getStatus() == TestResult.SUCCESS) {
            String errorMessage = "";
            try {
                softAssert.assertAll();
            } catch (AssertionError e) {
                errorMessage = errorMessage + e.getMessage();
            }

            if (errorMessage != "") {
                testResult.setStatus(TestResult.FAILURE);
                testResult.setThrowable(new AssertionError(errorMessage));
                config.log.warn("<------ Exiting afterInvocation with errorMessage = '{}'------>", errorMessage);
            }
        }

    }
}

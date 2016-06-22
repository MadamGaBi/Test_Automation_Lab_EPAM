package com.epam.calculator.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * Created by GaBi on 31.05.2016.
 *
 */
public class TestListener implements ITestListener {
    private int m_count = 0;

    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {
        long time =
                (iTestResult.getEndMillis() - iTestResult.getStartMillis());

        Reporter.log("</br> [Test: " + iTestResult.getTestContext().getName() +
                     "][Class: " + iTestResult.getTestClass().getName() +
                     "][Method: " + iTestResult.getMethod().getMethodName() +
                     "][#Parameters: " + iTestResult.getParameters().length +
                     "] - State [" + iTestResult.getStatus() +
                     "] - [Time: " + time + " ms] - " +
                     "[Thread ID: " + Thread.currentThread().getId() + "]\n");

        logConsole("[Test: " + iTestResult.getTestContext().getName() +
                   "][Class: " + iTestResult.getTestClass().getName() +
                   "][Method: " + iTestResult.getMethod().getMethodName() +
                   "] - State [" + iTestResult.getStatus() +"] - [Time: " + time + " ms]" + "\n");
    }

    public void onTestFailure(ITestResult iTestResult) {
        long time =
                (iTestResult.getEndMillis() - iTestResult.getStartMillis());

        Reporter.log("</br> [Test: " + iTestResult.getTestContext().getName() +
                "][Class: " + iTestResult.getTestClass().getName() +
                "][Method: " + iTestResult.getMethod().getMethodName() +
                "][#Parameters: " + iTestResult.getParameters().length +
                "] - State [" + iTestResult.getStatus() +
                "] - [Time: " + time + " ms]" +
                "Thread ID: " + Thread.currentThread().getId() + "\n");

        logConsole(iTestResult.getName()+ "--Test method failed\n");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        long time =
                (iTestResult.getEndMillis() - iTestResult.getStartMillis());

        Reporter.log("</br> [Test: " + iTestResult.getTestContext().getName() +
                "][Class: " + iTestResult.getTestClass().getName() +
                "][Method: " + iTestResult.getMethod().getMethodName() +
                "][#Parameters: " + iTestResult.getParameters().length +
                "] - State [" + iTestResult.getStatus() +
                "] - [Time: " + time + " ms]" +
                "Thread ID: " + Thread.currentThread().getId() + "\n");

        logConsole(iTestResult.getName()+ "--Test method skipped\n");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    public void onStart(ITestContext iTestContext) {
        System.out.println("[START]: " + iTestContext.getName());
    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println("[STOP]: " + iTestContext.getName());
    }

    private void logConsole(String string) {
        System.out.print(string);
        if (++m_count % 40 == 0) {
            System.out.println("");
        }
    }
}

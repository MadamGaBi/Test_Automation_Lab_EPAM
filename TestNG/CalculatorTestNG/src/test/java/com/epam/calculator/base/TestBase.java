package com.epam.calculator.base;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

/**
 * Created by GaBi on 22.05.2016.
 *
 */
public class TestBase extends Assert{

    @BeforeSuite
    public void beforeSuite() {
        print("Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        print("After Suite");
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        print("Before Test");
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        print("After Test");
    }

    @BeforeClass
    public void beforeClass() {
        print("Before Class");
    }

    @AfterClass
    public void AfterClass() {
        print("After Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        print("Before Method");
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        print(String.format("[%s] After Method", result.getMethod().getMethodName()));
    }

    protected void print(String msg) throws NumberFormatException{
        System.out.println(msg);
    }
}

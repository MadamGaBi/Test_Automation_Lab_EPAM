package com.epam.calculator.testCalculator.engineerOperations;

import com.epam.calculator.Calculator;
import com.epam.calculator.base.TestBase;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * class TestSin extends TestBase
 * and includes unit tests to test method sin
 * of class src\main\java\com\epam\calculator\Calculator.java
 *
 * Created by GaBi on 22.05.2016.
 */
public class TestSin extends TestBase {
    Calculator calculator = new Calculator();

    @Test(groups = {"smoke"}, threadPoolSize = 3, priority = 0)
    @Parameters({"numberSin", "resultSin"})
    public void testSinPassDouble(double number, double result) {
        assertEquals(calculator.sin(number), result, "error in sin()");
    }

//    @Test(groups = {}, threadPoolSize = 3, priority = 1)
//    public void testSinFailDouble(double number, double result) {
//        // TODO: 31.05.2016
//    }
//
//    @Test(expectedExceptions = Exception.class, groups = {}, threadPoolSize = 3, priority = 2)
//    public void testSinExceptionIsThrown (double number){
//        // TODO: 31.05.2016
//    }
}

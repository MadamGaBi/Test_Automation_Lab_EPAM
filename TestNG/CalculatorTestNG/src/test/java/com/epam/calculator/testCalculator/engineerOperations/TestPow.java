package com.epam.calculator.testCalculator.engineerOperations;

import com.epam.calculator.Calculator;
import com.epam.calculator.base.TestBase;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * class TestPow extends TestBase
 * and includes unit tests to test method pow
 * of class src\main\java\com\epam\calculator\Calculator.java
 *
 * Created by GaBi on 22.05.2016.
 */
public class TestPow extends TestBase {
    Calculator calculator = new Calculator();

    @Test(groups = {"smoke"}, threadPoolSize = 3, priority = 0)
    @Parameters({"numberPow1", "numberPow2", "resultPow"})
    public void testPowPassDouble(double number1, double number2, double result) {
        assertEquals(calculator.pow(number1, number2), result, "error in pow()");
    }

//    @Test(groups = {}, threadPoolSize = 3, priority = 1)
//    public void testPowFailDouble(double number, double result) {
//        // TODO: 31.05.2016
//    }
//
//    @Test(expectedExceptions = Exception.class, groups = {}, threadPoolSize = 3, priority = 2)
//    public void testPowExceptionIsThrown (double number){
//        // TODO: 31.05.2016
//    }
}

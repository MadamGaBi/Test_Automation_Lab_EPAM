package com.epam.calculator.testCalculator.engineerOperations;

import com.epam.calculator.Calculator;
import com.epam.calculator.base.TestBase;
import com.epam.calculator.dataProvider.DataProviderClass;
import com.sun.xml.internal.bind.v2.TODO;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * class TestCos extends TestBase
 * and includes unit tests to test method cos
 * of class src\main\java\com\epam\calculator\Calculator.java
 *
 * Created by GaBi on 22.05.2016.
 */
public class TestCos extends TestBase {
    Calculator calculator = new Calculator();

    @Test(groups = {"smoke"}, threadPoolSize = 3, priority = 0)
    @Parameters({"numberCos", "resultCos"})
    public void testCosPassDouble(double number, double result) {
        assertEquals(calculator.cos(number), result, "error in cos()");
    }

//    @Test(groups = {}, threadPoolSize = 3, priority = 1)
//    public void testCosFailDouble(double number, double result) {
//        // TODO: 31.05.2016
//    }
//
//    @Test(expectedExceptions = Exception.class, groups = {}, threadPoolSize = 3, priority = 2)
//    public void testCosExceptionIsThrown (double number){
//        // TODO: 31.05.2016
//    }
}

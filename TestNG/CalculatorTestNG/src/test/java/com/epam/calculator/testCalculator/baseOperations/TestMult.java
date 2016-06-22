package com.epam.calculator.testCalculator.baseOperations;

import com.epam.calculator.Calculator;
import com.epam.calculator.base.TestBase;
import com.epam.calculator.dataProvider.DataProviderClass;
import org.testng.annotations.Test;

/**
 * class TestMult extends TestBase
 * and includes unit tests to test method mult
 * of class src\main\java\com\epam\calculator\Calculator.java
 *
 * Created by GaBi on 22.05.2016.
 */
public class TestMult extends TestBase {
        Calculator calculator = new Calculator();

    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "ReadDataFromXmlFile",
          threadPoolSize = 3, groups = {"functional", "unit", "regression", "smoke"}, priority = 0)
    public void testMultPassLong(long number1, long number2, long result) {
        assertEquals(calculator.mult(number1, number2), result, "error in mult()");
    }

    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "ReadDataFromXmlFile",
          threadPoolSize = 3, groups = {"functional", "unit", "regression"}, priority = 1)
    public void testMultFailLong(long number1, long number2, long result) {
        assertNotEquals(calculator.mult(number1, number2), result, "error in mult()");
    }

    @Test(expectedExceptions = Exception.class,
            dataProviderClass = DataProviderClass.class, dataProvider = "ReadDataFromXmlFile",
            threadPoolSize = 3, groups = {"functional", "unit", "regression"}, priority = 2)
    public void testMultExceptionIsThrown (long number1, long number2){
        calculator.mult(number1, number2);
    }
}

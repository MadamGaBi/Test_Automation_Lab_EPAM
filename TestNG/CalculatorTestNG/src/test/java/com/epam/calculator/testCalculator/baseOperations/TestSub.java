package com.epam.calculator.testCalculator.baseOperations;

import com.epam.calculator.Calculator;
import com.epam.calculator.base.TestBase;
import com.epam.calculator.dataProvider.DataProviderClass;
import org.testng.annotations.Test;

/**
 * class TestSub extends TestBase
 * and includes unit tests to test method sub
 * of class src\main\java\com\epam\calculator\Calculator.java
 *
 * Created by GaBi on 22.05.2016.
 */
public class TestSub extends TestBase{
        Calculator calculator = new Calculator();

    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "ReadDataFromXmlFile",
          threadPoolSize = 3, groups = {"functional", "unit", "regression", "smoke"}, priority = 0)
    public void testSubPassLong(long number1, long number2, long result) {
        assertEquals(calculator.sub(number1, number2), result, "error in sub()");
    }

    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "ReadDataFromXmlFile",
          threadPoolSize = 3, groups = {"functional", "unit", "regression"}, priority = 1)
    public void testSubFailLong(long number1, long number2, long result) {
        assertNotEquals(calculator.sub(number1, number2), result, "error in sub()");
    }

    @Test(expectedExceptions = Exception.class,
            dataProviderClass = DataProviderClass.class, dataProvider = "ReadDataFromXmlFile",
            threadPoolSize = 3, groups = {"functional", "unit", "regression"}, priority = 2)
    public void testSubExceptionIsThrown (long number1, long number2){
        calculator.sub(number1, number2);
    }
}

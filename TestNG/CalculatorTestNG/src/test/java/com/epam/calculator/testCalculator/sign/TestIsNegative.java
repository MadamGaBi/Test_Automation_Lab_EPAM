package com.epam.calculator.testCalculator.sign;

import com.epam.calculator.Calculator;
import com.epam.calculator.base.TestBase;
import com.epam.calculator.dataProvider.DataProviderClass;
import org.testng.annotations.Test;

/**
 * class TestIsNegative extends TestBase
 * and includes unit tests to test method isNegative
 * of class src\main\java\com\epam\calculator\Calculator.java
 *
 * Created by GaBi on 22.05.2016.
 */
public class TestIsNegative extends TestBase {
    Calculator calculator = new Calculator();

    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "ReadDataFromXmlFile",
            threadPoolSize = 3, groups = {"functional", "unit", "regression"}, priority = 0)
    public void testIsNegativePassLong(long number) {
        assertEquals(calculator.isNegative(number), true, "error in isNegative()");
    }

    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "ReadDataFromXmlFile",
            threadPoolSize = 3, groups = {"functional", "unit", "regression"}, priority = 1)
    public void testIsNegativeFailLong(long number) {
        assertEquals(calculator.isNegative(number), false, "error in isNegative()");
    }
}

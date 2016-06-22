package com.epam.calculator.testCalculator.sign;

import com.epam.calculator.Calculator;
import com.epam.calculator.base.TestBase;
import com.epam.calculator.dataProvider.DataProviderClass;
import org.testng.annotations.Test;

/**
 * class TestIsPositive extends TestBase
 * and includes unit tests to test method isPositive
 * of class src\main\java\com\epam\calculator\Calculator.java
 *
 * Created by GaBi on 22.05.2016.
 */
public class TestIsPositive extends TestBase {
    Calculator calculator = new Calculator();

    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "ReadDataFromXmlFile",
            threadPoolSize = 3, groups = {"functional", "unit", "regression"}, priority = 0)
    public void testIsPositivePassLong(long number) {
        assertEquals(calculator.isPositive(number), true, "error in isPositive()");
    }

    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "ReadDataFromXmlFile",
            threadPoolSize = 3, groups = {"functional", "unit", "regression"}, priority = 1)
    public void testIsPositiveFailLong(long number) {
        assertEquals(calculator.isPositive(number), false, "error in isPositive()");
    }
}

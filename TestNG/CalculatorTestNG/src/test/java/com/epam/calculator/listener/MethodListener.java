package com.epam.calculator.listener;

import org.testng.*;

/**
 * Created by GaBi on 31.05.2016.
 *
 */
public class MethodListener implements IInvokedMethodListener {

    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        Reporter.log("</br>" + "Begin executing method: " + returnMethodName(iInvokedMethod.getTestMethod()));
    }

    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        Reporter.log("</br>" + "Completed executing method: " + returnMethodName(iInvokedMethod.getTestMethod()) +
                " Elapsed time: " + (iTestResult.getStartMillis() - iTestResult.getEndMillis()));
    }

    private String returnMethodName(ITestNGMethod method) {
        return method.getRealClass().getSimpleName() + "." + method.getMethodName();
    }
}

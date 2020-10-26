package org.cechc.elt.general.test.testcase;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Report extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
        result.getThrowable().printStackTrace();
    }
}

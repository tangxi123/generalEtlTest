package org.cechc.elt.general.test.testcase;

import org.cechc.elt.general.test.pojo.TestCase;
import org.testng.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class InvokedMethodListenerImp implements IInvokedMethodListener2 {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        Object instance1 = testResult.getInstance();
        EtlTest instance = (EtlTest) testResult.getInstance();
        TestCase testCase = instance.getTestCase();
        System.out.println("开始调用。。。。"+testCase.getName());


    }


    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        System.out.println("结束调用。。。。"+testResult.getName());
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

    }
}

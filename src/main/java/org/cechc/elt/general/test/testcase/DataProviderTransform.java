package org.cechc.elt.general.test.testcase;

import org.testng.IAnnotationTransformer2;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class DataProviderTransform implements IAnnotationTransformer2 {
    @Override
    public void transform(IConfigurationAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

    }

    @Override
    public void transform(IDataProviderAnnotation annotation, Method method) {
        System.out.println("dataprovider: "+method.getName());

    }

    @Override
    public void transform(IFactoryAnnotation annotation, Method method) {

}

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

    }
}

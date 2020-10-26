package org.cechc.elt.general.test;

import org.cechc.elt.general.test.testcase.TestInterface;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class RunTestCase {
    public static void main(String[] args) {
//        XmlSuite xmlSuite = new XmlSuite();
//        xmlSuite.setName("testCaseFactory");
//        xmlSuite.addListener("org.cechc.elt.general.test.testcase.InvokedMethodListenerImp");
//        XmlTest test = new XmlTest(xmlSuite);
//        test.setName("EtlTest");
//        ArrayList<XmlClass> xmlClasses = new ArrayList<>();
//        xmlClasses.add(new XmlClass("org.cechc.elt.general.test.testcase.EtlTestCaseFactory"));
//        test.setXmlClasses(xmlClasses);
//        List<XmlSuite> suites = new ArrayList<XmlSuite>();
//        suites.add(xmlSuite);
//        TestNG tng = new TestNG();
//        tng.setXmlSuites(suites);
//        tng.run();

        HashMap<String,Object> sourceValues = new HashMap<>();
        sourceValues.put("id",1);
        sourceValues.put("isFlag",1);
        sourceValues.put("lastDayMoney",345);
        sourceValues.put("todayMoney",1000);

        HashMap<String,Object> targetValues = new HashMap<>();
        targetValues.put("id",1);
        targetValues.put("isFlag",true);
        targetValues.put("totalMoney",1345);

        HashMap<String,String> rules = new HashMap<>();
        rules.put("id","id");
        rules.put("bool(isFlag)","isFlag");
        rules.put("add(lastDayMoney,todayMoney)","totalMoney");

        File file = new File("/Users/tangqian/Documents/code/loadJarTest/target/loadJarTest-1.0-SNAPSHOT.jar");
        try {
            // Convert File to a URL
            URL url = file.toURI().toURL();          // file:/c:/myclasses/
            URL[] urls = new URL[]{url};

            // Create a new class loader with the directory
            ClassLoader cl = new URLClassLoader(urls);


            // Load in the class; MyClass.class should be located in
            // the directory file:/c:/myclasses/com/mycompany
            Class cls = cl.loadClass("org.tangxi.BoolFunc");
            Method[] declaredMethods = cls.getDeclaredMethods();
            rules.keySet();


            Object n = null;
            System.out.println(cls.getMethod("bool", Object.class).invoke(null, n));
            Class cls2 = cl.loadClass("org.tangxi.TwoParamsAdd");
            System.out.println(cls2.getMethod("add",Integer.class,Integer.class).invoke(null,10,3));
//            System.out.println(ClassLoader.getSystemClassLoader());
//            System.out.println(cls.getClassLoader());
//            TestInterface o = (TestInterface)cls.newInstance();
//            o.test();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

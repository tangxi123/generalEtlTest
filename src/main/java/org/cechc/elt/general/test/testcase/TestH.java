package org.cechc.elt.general.test.testcase;



public class TestH implements TestInterface {
    public static void main(String[] args) {
        new TestH().test();
        String property = System.getProperty("sun.boot.class.path");
        System.out.println(property);
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
    public void test() {
        System.out.println("hello!!");
    }
}

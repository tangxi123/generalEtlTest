package org.cechc.elt.general.test.func;

public class MapToObjectFunc implements FieldFunction{
    public static Object mapToObject(Object param,Object obj){
        return obj;
    }

    public static void main(String[] args) {
        Object hello = mapToObject("男", 0);
        System.out.println(hello);
    }
}

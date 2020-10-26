package org.cechc.elt.general.test.func;

import java.util.HashMap;

public class IfFunc implements FieldFunction {
    public static Object ifFunc(Boolean expr1,Object expr2,Object expr3){
        return expr1 ? expr2 : expr3;
    }

    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("sex","男");
        Object o = ifFunc(hashMap.get("sex").equals("女"), 1, "哈哈哈哈");
        System.out.println(o);
    }
}

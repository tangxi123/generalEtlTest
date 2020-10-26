package org.cechc.elt.general.test.testcase;

import org.cechc.elt.general.test.pojo.SqlMap;
import org.cechc.elt.general.test.pojo.TestCase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class EtlTest {
    private TestCase testCase;

    public EtlTest(TestCase testCase) {
        this.testCase = testCase;
    }
    public TestCase getTestCase(){
        return testCase;
    }

    @DataProvider(name = "dp")
    public Object[][] createData1() {
        String sourceSql = testCase.getSourceSql();
        HashMap<String,Object> sourceResult = new HashMap<>();
        HashMap<String,Object> destResult = new HashMap<>();
        sourceResult.put("total",100);
        destResult.put("total",200);
        ArrayList<HashMap<String, Object>> hashMaps = new ArrayList<>();
        hashMaps.add(sourceResult);
        hashMaps.add(destResult);

        return new Object[][]{
                {hashMaps}
        };
    }

    @Test(dataProvider = "dp")
    public void compare_source_and_destination(HashMap<String,Object> result) {
        HashMap<String, Object> sqlMap = testCase.getSqlMap();
        Set<Map.Entry<String, Object>> entries = sqlMap.entrySet();
        String sourceKey;
        String destKey;
        for(Map.Entry<String,Object> entry : entries){
            sourceKey =  entry.getKey();
            destKey = (String)entry.getValue();
            Object sourceValue = result.get(sourceKey);
            Object destValue = result.get(destKey);
            Assert.assertEquals(sourceValue,destValue);
        }

    }

}

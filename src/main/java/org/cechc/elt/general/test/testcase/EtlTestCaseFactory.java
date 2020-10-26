package org.cechc.elt.general.test.testcase;

import org.cechc.elt.general.test.pojo.SqlMap;
import org.cechc.elt.general.test.pojo.TestCase;
import org.testng.annotations.Factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EtlTestCaseFactory {


    @Factory
    public Object[] createTestCase(){
        List<EtlTest> etlTests = initialize();
        Object[] objects = etlTests.toArray(new Object[etlTests.size()]);
        return objects;
    }

    private List<EtlTest> initialize(){
        List<EtlTest> etlTests = new ArrayList<>();
//        for(int i=0; i<10; i++){
//            SqlMap sqlMap = new SqlMap(null,null,null,null,null);
            TestCase testCase1 = new TestCase();
            testCase1.setName("compare_patient_count");
            testCase1.setDescription("对比源数据和目标数据的病人条数");
            testCase1.setSourceSql("select count(*) as total from patient");
            testCase1.setDestSql("select count(*) as total from provider");
            HashMap<String, Object> stringObjectHashMap = new HashMap<>();
            stringObjectHashMap.put("total","total");
            testCase1.setSqlMap(stringObjectHashMap);
            TestCase testCase2 = new TestCase();
            testCase2.setName("compare_admission_count");
            testCase2.setDescription("对比源数据和目标数据的住院条数");
            testCase2.setSourceSql("select count(*) as total from admission");
            testCase2.setDestSql("select count(*) as total from encounter");
            HashMap<String, Object> stringObjectHashMap2 = new HashMap<>();
            stringObjectHashMap.put("total","total");
            testCase1.setSqlMap(stringObjectHashMap2);
            etlTests.add(new EtlTest(testCase1));
            etlTests.add(new EtlTest(testCase2));

//        }
        return etlTests;
    }
}

package org.cechc.elt.general.test.pojo;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.UUID;

public class TestCase {
    private String id;
    private String name;
    private String description;
    private SqlMap sqlMap;

    public TestCase(){}

    public TestCase(String name,String description,SqlMap sqlMap){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.sqlMap = sqlMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public SqlMap getSqlMap() {
        return sqlMap;
    }

    public void setSqlMap(SqlMap sqlMap) {
        this.sqlMap = sqlMap;
    }




}

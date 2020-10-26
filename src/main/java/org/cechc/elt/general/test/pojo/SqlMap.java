package org.cechc.elt.general.test.pojo;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SqlMap {
   final private String id;
    final private SqlInfo sourceSqlInfo;
    final private SqlInfo destSqlInfo;
    final private List<HashMap<String,String>> mappingRules;



    public SqlMap(String dataSourceId,SqlInfo sourceSqlInfo,SqlInfo destSqlInfo,String dataTargetSql,List<HashMap<String,String>> mappingRules){
        this.id = UUID.randomUUID().toString();
        this.sourceSqlInfo = sourceSqlInfo;
        this.destSqlInfo = destSqlInfo;
        this.mappingRules = mappingRules;
    }

    public String getId() {
        return id;
    }

    public SqlInfo getSourceSqlInfo() {
        return sourceSqlInfo;
    }

    public SqlInfo getDestSqlInfo() {
        return destSqlInfo;
    }

    public List<HashMap<String, String>> getMappingRules() {
        return mappingRules;
    }
}

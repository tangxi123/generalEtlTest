package org.cechc.elt.general.test.pojo;

import java.util.UUID;

public class SqlInfo {
    final private String id;
    final private String datasourceId;
    final private String sqlDescription;
    final private String sql;

    public SqlInfo(String datasourceId, String sqlDescription, String sql) {
        this.id = UUID.randomUUID().toString();
        this.datasourceId = datasourceId;
        this.sqlDescription = sqlDescription;
        this.sql = sql;
    }

    public String getId() {
        return id;
    }

    public String getDatasourceId() {
        return datasourceId;
    }

    public String getSqlDescription() {
        return sqlDescription;
    }

    public String getSql() {
        return sql;
    }
}

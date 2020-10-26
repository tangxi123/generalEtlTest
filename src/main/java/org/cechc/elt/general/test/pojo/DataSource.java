package org.cechc.elt.general.test.pojo;

import java.util.UUID;

public class DataSource{
    final private String id;
    final private String driverClassName;
    final  private String url;
    final private String username;
    final private String password;

    public DataSource(String driverClassName,String url,String username,String password){
        this.id = UUID.randomUUID().toString();
        this.driverClassName = driverClassName;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

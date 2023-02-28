package com.rongji.egov.test.model;

import com.rongji.egov.mybatis.base.annotation.Mapping;
import com.rongji.egov.mybatis.base.annotation.Table;
import com.rongji.egov.mybatis.base.annotation.TypeHandler;
import com.rongji.egov.mybatis.base.wrapper.JsonTypeHandler;
import com.rongji.egov.test.base.model.GenericForm;

import java.util.Set;


@SuppressWarnings("unused")
@Table(value = "VI_DATA_DS_SETTING", dac = true, mapping = Mapping.UNDERSCORE)
public class DsSetting extends GenericForm {
    private String label;
    private String name;
    private String url;
    private String driverClassName;
    private String username;
    private String password;
    private String type;
    private String memo;

    //private String log;

    //@Reader(ACL.PUB)  //暫不啟用
    @TypeHandler(JsonTypeHandler.class)
    private Set<String> readers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Set<String> getReaders() {
        return readers;
    }

    public void setReaders(Set<String> readers) {
        this.readers = readers;
    }
}
package com.rongji.egov.test.model;

import com.rongji.egov.mybatis.base.annotation.Mapping;
import com.rongji.egov.mybatis.base.annotation.Table;
import com.rongji.egov.mybatis.base.annotation.TypeHandler;
import com.rongji.egov.mybatis.base.wrapper.ClassTypeHandler;
import com.rongji.egov.mybatis.base.wrapper.JsonTypeHandler;
import com.rongji.egov.test.base.model.GenericForm;
import com.rongji.egov.test.model.reference.FieldList;
import com.rongji.egov.test.model.reference.TableSettingAclFilter;

import java.util.Set;


@SuppressWarnings("unused")
@Table(value = "VI_DATA_TABLE_SETTING", dac = true, mapping = Mapping.UNDERSCORE)
public class TableSetting extends GenericForm {
    private String label;   //展示名称（中文名）
    private String tableName;   //表名称，实际表名
    private String className;   //映射java类名称，使用驼峰命名。格式：源.表名
    private boolean dac;    //启用权限控制

    @TypeHandler(ClassTypeHandler.class)
    private Class<?> privilege;    //权限控制器

    @TypeHandler(JsonTypeHandler.class)
    private FieldList fields;

    @TypeHandler(JsonTypeHandler.class)
    private Set<String> sources;

    @TypeHandler(JsonTypeHandler.class)
    private TableSettingAclFilter aclFilter;

    private String memo;

    //@Reader(ACL.PUB)  //暫不啟用
    @TypeHandler(JsonTypeHandler.class)
    private Set<String> readers;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public boolean isDac() {
        return dac;
    }

    public void setDac(boolean dac) {
        this.dac = dac;
    }

    public Class<?> getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Class<?> privilege) {
        this.privilege = privilege;
    }

    public FieldList getFields() {
        return fields;
    }

    public void setFields(FieldList fields) {
        this.fields = fields;
    }

    public Set<String> getSources() {
        return sources;
    }

    public void setSources(Set<String> sources) {
        this.sources = sources;
    }

    public TableSettingAclFilter getAclFilter() {
        return aclFilter;
    }

    public void setAclFilter(TableSettingAclFilter aclFilter) {
        this.aclFilter = aclFilter;
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
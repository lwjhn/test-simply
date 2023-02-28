package com.rongji.egov.test.model.reference;

import java.io.Serializable;

/**
 * Author: lwjhn
 * Date: 2022/10/17 9:33
 * Description:
 */
public class Field implements Serializable {
    private String label;  //中文显示名称
    private String name;    //表字段名称
    private String alias;   //类属性名，使用驼峰命名
    private Class<?> type;  //映射JAVA类型
    private Permission permission;  //读者域定义

    private Class<?> typeHandler;   // mybatis转换类

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Class<?> getTypeHandler() {
        return typeHandler;
    }

    public void setTypeHandler(Class<?> typeHandler) {
        this.typeHandler = typeHandler;
    }
}

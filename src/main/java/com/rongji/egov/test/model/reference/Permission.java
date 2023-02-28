package com.rongji.egov.test.model.reference;

import com.rongji.egov.mybatis.base.annotation.ACL;

import java.io.Serializable;
import java.util.Set;

/**
 * Author: lwjhn
 * Date: 2022/10/17 10:06
 * Description:
 */
public class Permission implements Serializable {
    Set<ACL> value;
    String prefix = "%";
    String suffix = "%";
    boolean editor = false;

    public Set<ACL> getValue() {
        return value;
    }

    public void setValue(Set<ACL> value) {
        this.value = value;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public boolean isEditor() {
        return editor;
    }

    public void setEditor(boolean editor) {
        this.editor = editor;
    }
}

package com.rongji.egov.test.model;

import com.rongji.egov.mybatis.base.annotation.Table;

import java.io.Serializable;

@Table(value = "EGOV_BBS", dac = true)
public class BbsCommon implements Serializable {

    private String id;

    private String subject;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

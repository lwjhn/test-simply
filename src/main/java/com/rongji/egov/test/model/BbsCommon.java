package com.rongji.egov.test.model;

import com.rongji.egov.mybatis.base.annotation.ACL;
import com.rongji.egov.mybatis.base.annotation.Editor;
import com.rongji.egov.mybatis.base.annotation.PrimaryKey;
import com.rongji.egov.mybatis.base.annotation.Table;

import java.io.Serializable;

@Table(value = "EGOV_BBS", dac = true)
public class BbsCommon implements Serializable {
    @PrimaryKey
    private String id;

    private String subject;

    private String content;

    @Editor(ACL.USER)
    private String publisherNo;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublisherNo() {
        return publisherNo;
    }

    public void setPublisherNo(String publisherNo) {
        this.publisherNo = publisherNo;
    }
}

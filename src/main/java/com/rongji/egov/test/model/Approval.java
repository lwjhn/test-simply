package com.rongji.egov.test.model;

import com.facebook.presto.jdbc.PrestoArray;
import com.rongji.egov.mybatis.base.annotation.Column;
import com.rongji.egov.mybatis.base.annotation.Mapping;
import com.rongji.egov.mybatis.base.annotation.Table;

import java.util.Date;

/**
 * Author: lwjhn
 * Date: 2023/2/21 16:06
 * Description:
 */
@Table(value = "mongodb.approval.approval", mapping = {Mapping.ANNOTATION, Mapping.ORIGIN})
public class Approval {
    @Column("_id")
    private String id;
    private String businessCate;
    private String businessName;
    private String draftuserunit;
    private String flowStatus;
    private Date draftDate;
    private Object readers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusinessCate() {
        return businessCate;
    }

    public void setBusinessCate(String businessCate) {
        this.businessCate = businessCate;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getFlowStatus() {
        return flowStatus;
    }

    public void setFlowStatus(String flowStatus) {
        this.flowStatus = flowStatus;
    }

    public Date getDraftDate() {
        return draftDate;
    }

    public void setDraftDate(Date draftDate) {
        this.draftDate = draftDate;
    }

    public Object getReaders() {
        return readers;
    }

    public void setReaders(Object readers) {
        this.readers = readers;
    }

    public String getDraftuserunit() {
        return draftuserunit;
    }

    public void setDraftuserunit(String draftuserunit) {
        this.draftuserunit = draftuserunit;
    }
}

package com.rongji.egov.test.model;

import com.rongji.egov.mybatis.base.annotation.Mapping;
import com.rongji.egov.mybatis.base.annotation.Table;

import java.util.Date;

@Table(value = "UMS_USER_ORG_RELATE", mapping = Mapping.UNDERSCORE)
public class MyUserOrgRelate {

    private String id;


    private Integer sortNo;


    private String userNo;


    private String orgNo;


    private String isPrimary;


    private String job;


    private Date createTime;


    private Date modifyTime;


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }


    public Integer getSortNo() {
        return sortNo;
    }


    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }


    public String getUserNo() {
        return userNo;
    }


    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }


    public String getOrgNo() {
        return orgNo;
    }


    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo == null ? null : orgNo.trim();
    }


    public String getIsPrimary() {
        return isPrimary;
    }


    public void setIsPrimary(String isPrimary) {
        this.isPrimary = isPrimary == null ? null : isPrimary.trim();
    }


    public String getJob() {
        return job;
    }


    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }


    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Date getModifyTime() {
        return modifyTime;
    }


    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
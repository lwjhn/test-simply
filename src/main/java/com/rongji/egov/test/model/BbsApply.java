package com.rongji.egov.test.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

/**
 * 报名
 *
 * @author chenjingyu
 * @date 2021-03-09
 **/
public class BbsApply {

    private String id;

    /**
     * 关联的bbsId
     */
    private String bbsId;

    /**
     * 报名人单位
     */
    private String applyUserUnit;
    private String applyUserUnitNo;

    /**
     * 报名人部门
     */
    private String applyUserOrg;
    private String applyUserOrgNo;

    /**
     * 报名人姓名
     */
    private String applyUser;
    private String applyUserNo;

    /**
     * 报名人联系电话
     */
    private String applyUserMobile;

    /**
     * 报名时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp applyTime;

    /**
     * 拟稿人
     */
    private String draftUser;
    private String draftUserNo;

    /**
     * 系统编号
     */
    private String systemNo;

    //查询使用
    /**
     *报名分页查询类型
     */
    private String searchType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBbsId() {
        return bbsId;
    }

    public void setBbsId(String bbsId) {
        this.bbsId = bbsId;
    }

    public String getApplyUserUnit() {
        return applyUserUnit;
    }

    public void setApplyUserUnit(String applyUserUnit) {
        this.applyUserUnit = applyUserUnit;
    }

    public String getApplyUserUnitNo() {
        return applyUserUnitNo;
    }

    public void setApplyUserUnitNo(String applyUserUnitNo) {
        this.applyUserUnitNo = applyUserUnitNo;
    }

    public String getApplyUserOrg() {
        return applyUserOrg;
    }

    public void setApplyUserOrg(String applyUserOrg) {
        this.applyUserOrg = applyUserOrg;
    }

    public String getApplyUserOrgNo() {
        return applyUserOrgNo;
    }

    public void setApplyUserOrgNo(String applyUserOrgNo) {
        this.applyUserOrgNo = applyUserOrgNo;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyUserNo() {
        return applyUserNo;
    }

    public void setApplyUserNo(String applyUserNo) {
        this.applyUserNo = applyUserNo;
    }

    public String getApplyUserMobile() {
        return applyUserMobile;
    }

    public void setApplyUserMobile(String applyUserMobile) {
        this.applyUserMobile = applyUserMobile;
    }

    public Timestamp getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Timestamp applyTime) {
        this.applyTime = applyTime;
    }

    public String getDraftUser() {
        return draftUser;
    }

    public void setDraftUser(String draftUser) {
        this.draftUser = draftUser;
    }

    public String getDraftUserNo() {
        return draftUserNo;
    }

    public void setDraftUserNo(String draftUserNo) {
        this.draftUserNo = draftUserNo;
    }

    public String getSystemNo() {
        return systemNo;
    }

    public void setSystemNo(String systemNo) {
        this.systemNo = systemNo;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }
}

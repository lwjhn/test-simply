package com.rongji.egov.test.model;

import com.rongji.egov.mybatis.base.annotation.Mapping;
import com.rongji.egov.mybatis.base.annotation.Table;

import java.util.Date;

@Table(value = "UMS_ORG", mapping = Mapping.UNDERSCORE)
public class MyUmsOrg {
    
    private String id;

    
    private Integer sortNo;

    
    private String pOrgNo;

    
    private String unitNo;

    
    private String unitName;

    
    private String orgNo;

    
    private String orgName;

    
    private String orgType;

    
    private String status;

    
    private String orgNoList;

    
    private String orgNameList;

    
    private String orgLevel;

    
    private String shortName;

    
    private String aliasName;

    
    private String hrNo;

    
    private String address;

    
    private String telephone;

    
    private String remark;

    
    private Date createTime;

    
    private Date modifyTime;

    
    private String totalSortNo;

    
    private String secLevel;

    
    private String uniCode;

    
    private String themeNo;

    
    private String isShow;

    
    private String isVirtual;

    
    private String systemNo;

    
    private String orgSortNo;

    
    private String labels;

    
    private String showContact;

    
    private String unitType;

    
    private String fax;

    
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

    
    public String getpOrgNo() {
        return pOrgNo;
    }

    
    public void setpOrgNo(String pOrgNo) {
        this.pOrgNo = pOrgNo == null ? null : pOrgNo.trim();
    }

    
    public String getUnitNo() {
        return unitNo;
    }

    
    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo == null ? null : unitNo.trim();
    }

    
    public String getUnitName() {
        return unitName;
    }

    
    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    
    public String getOrgNo() {
        return orgNo;
    }

    
    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo == null ? null : orgNo.trim();
    }

    
    public String getOrgName() {
        return orgName;
    }

    
    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    
    public String getOrgType() {
        return orgType;
    }

    
    public void setOrgType(String orgType) {
        this.orgType = orgType == null ? null : orgType.trim();
    }

    
    public String getStatus() {
        return status;
    }

    
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    
    public String getOrgNoList() {
        return orgNoList;
    }

    
    public void setOrgNoList(String orgNoList) {
        this.orgNoList = orgNoList == null ? null : orgNoList.trim();
    }

    
    public String getOrgNameList() {
        return orgNameList;
    }

    
    public void setOrgNameList(String orgNameList) {
        this.orgNameList = orgNameList == null ? null : orgNameList.trim();
    }

    
    public String getOrgLevel() {
        return orgLevel;
    }

    
    public void setOrgLevel(String orgLevel) {
        this.orgLevel = orgLevel == null ? null : orgLevel.trim();
    }

    
    public String getShortName() {
        return shortName;
    }

    
    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    
    public String getAliasName() {
        return aliasName;
    }

    
    public void setAliasName(String aliasName) {
        this.aliasName = aliasName == null ? null : aliasName.trim();
    }

    
    public String getHrNo() {
        return hrNo;
    }

    
    public void setHrNo(String hrNo) {
        this.hrNo = hrNo == null ? null : hrNo.trim();
    }

    
    public String getAddress() {
        return address;
    }

    
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    
    public String getTelephone() {
        return telephone;
    }

    
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    
    public String getRemark() {
        return remark;
    }

    
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    
    public String getTotalSortNo() {
        return totalSortNo;
    }

    
    public void setTotalSortNo(String totalSortNo) {
        this.totalSortNo = totalSortNo == null ? null : totalSortNo.trim();
    }

    
    public String getSecLevel() {
        return secLevel;
    }

    
    public void setSecLevel(String secLevel) {
        this.secLevel = secLevel == null ? null : secLevel.trim();
    }

    
    public String getUniCode() {
        return uniCode;
    }

    
    public void setUniCode(String uniCode) {
        this.uniCode = uniCode == null ? null : uniCode.trim();
    }

    
    public String getThemeNo() {
        return themeNo;
    }

    
    public void setThemeNo(String themeNo) {
        this.themeNo = themeNo == null ? null : themeNo.trim();
    }

    
    public String getIsShow() {
        return isShow;
    }

    
    public void setIsShow(String isShow) {
        this.isShow = isShow == null ? null : isShow.trim();
    }

    
    public String getIsVirtual() {
        return isVirtual;
    }

    
    public void setIsVirtual(String isVirtual) {
        this.isVirtual = isVirtual == null ? null : isVirtual.trim();
    }

    
    public String getSystemNo() {
        return systemNo;
    }

    
    public void setSystemNo(String systemNo) {
        this.systemNo = systemNo == null ? null : systemNo.trim();
    }

    
    public String getOrgSortNo() {
        return orgSortNo;
    }

    
    public void setOrgSortNo(String orgSortNo) {
        this.orgSortNo = orgSortNo == null ? null : orgSortNo.trim();
    }

    
    public String getLabels() {
        return labels;
    }

    
    public void setLabels(String labels) {
        this.labels = labels == null ? null : labels.trim();
    }

    
    public String getShowContact() {
        return showContact;
    }

    
    public void setShowContact(String showContact) {
        this.showContact = showContact == null ? null : showContact.trim();
    }

    
    public String getUnitType() {
        return unitType;
    }

    
    public void setUnitType(String unitType) {
        this.unitType = unitType == null ? null : unitType.trim();
    }

    
    public String getFax() {
        return fax;
    }

    
    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }
}
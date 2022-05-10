package com.rongji.egov.test.model;

import com.rongji.egov.mybatis.base.annotation.Column;
import com.rongji.egov.mybatis.base.annotation.Mapping;
import com.rongji.egov.mybatis.base.annotation.Table;

import java.math.BigDecimal;
import java.util.Date;

@Table(value = "UMS_USER", mapping = Mapping.UNDERSCORE)
public class MyUmsUser {

    private String id;


    private Integer sortNo;


    private String userNo;


    private String userName;


    private String status;


    private String password;


    private String shortName;


    private String aliasNames;


    private String title;


    private String userLevel;

    @Column(exist = false)
    private String job;

    @Column(exist = false)
    private String employeeType;

    @Column(exist = false)
    private String employeeNo;

    @Column(exist = false)
    private String caCode;

    @Column(exist = false)
    private String adCode;

    private String identityNo;


    private String gender;


    private String telephone;


    private String mobile;


    private String qqCode;


    private String microLetter;


    private String microBlog;


    private String email;

    @Column(exist = false)
    private String mail;


    private String address;


    private String postcode;


    private String fax;

    @Column(exist = false)
    private String website;

    @Column(exist = false)
    private String blog;

    @Column(exist = false)
    private String content;

    @Column(exist = false)
    private Date createTime;

    @Column(exist = false)
    private Date modifyTime;

    @Column(exist = false)
    private Date birthday;

    @Column(exist = false)
    private Date modifyPwdTime;

    @Column(exist = false)
    private Integer loginFailTimes;

    @Column(exist = false)
    private Date loginLastTime;

    @Column(exist = false)
    private String themeNo;

    @Column(exist = false)
    private String homePhone;

    @Column(exist = false)
    private String skinColor;

    @Column(exist = false)
    private String hrNo;

    @Column(exist = false)
    private String systemNo;

    @Column(exist = false)
    private Date entryDate;

    @Column(exist = false)
    private String secLevel;

    @Column(exist = false)
    private String loginOrgNo;

    @Column(exist = false)
    private String receiveSms;

    @Column(exist = false)
    private String showMobile;

    @Column(exist = false)
    private BigDecimal totalSortNo;

    @Column(exist = false)
    private String deanMac;

    @Column(exist = false)
    private String deanFlag;


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


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }


    public String getShortName() {
        return shortName;
    }


    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }


    public String getAliasNames() {
        return aliasNames;
    }


    public void setAliasNames(String aliasNames) {
        this.aliasNames = aliasNames == null ? null : aliasNames.trim();
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }


    public String getUserLevel() {
        return userLevel;
    }


    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel == null ? null : userLevel.trim();
    }


    public String getJob() {
        return job;
    }


    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }


    public String getEmployeeType() {
        return employeeType;
    }


    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType == null ? null : employeeType.trim();
    }


    public String getEmployeeNo() {
        return employeeNo;
    }


    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo == null ? null : employeeNo.trim();
    }


    public String getCaCode() {
        return caCode;
    }


    public void setCaCode(String caCode) {
        this.caCode = caCode == null ? null : caCode.trim();
    }


    public String getAdCode() {
        return adCode;
    }


    public void setAdCode(String adCode) {
        this.adCode = adCode == null ? null : adCode.trim();
    }


    public String getIdentityNo() {
        return identityNo;
    }


    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo == null ? null : identityNo.trim();
    }


    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }


    public String getTelephone() {
        return telephone;
    }


    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }


    public String getMobile() {
        return mobile;
    }


    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }


    public String getQqCode() {
        return qqCode;
    }


    public void setQqCode(String qqCode) {
        this.qqCode = qqCode == null ? null : qqCode.trim();
    }


    public String getMicroLetter() {
        return microLetter;
    }


    public void setMicroLetter(String microLetter) {
        this.microLetter = microLetter == null ? null : microLetter.trim();
    }


    public String getMicroBlog() {
        return microBlog;
    }


    public void setMicroBlog(String microBlog) {
        this.microBlog = microBlog == null ? null : microBlog.trim();
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }


    public String getMail() {
        return mail;
    }


    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }


    public String getPostcode() {
        return postcode;
    }


    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }


    public String getFax() {
        return fax;
    }


    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }


    public String getWebsite() {
        return website;
    }


    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }


    public String getBlog() {
        return blog;
    }


    public void setBlog(String blog) {
        this.blog = blog == null ? null : blog.trim();
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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


    public Date getBirthday() {
        return birthday;
    }


    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    public Date getModifyPwdTime() {
        return modifyPwdTime;
    }


    public void setModifyPwdTime(Date modifyPwdTime) {
        this.modifyPwdTime = modifyPwdTime;
    }


    public Integer getLoginFailTimes() {
        return loginFailTimes;
    }


    public void setLoginFailTimes(Integer loginFailTimes) {
        this.loginFailTimes = loginFailTimes;
    }


    public Date getLoginLastTime() {
        return loginLastTime;
    }


    public void setLoginLastTime(Date loginLastTime) {
        this.loginLastTime = loginLastTime;
    }


    public String getThemeNo() {
        return themeNo;
    }


    public void setThemeNo(String themeNo) {
        this.themeNo = themeNo == null ? null : themeNo.trim();
    }


    public String getHomePhone() {
        return homePhone;
    }


    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone == null ? null : homePhone.trim();
    }


    public String getSkinColor() {
        return skinColor;
    }


    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor == null ? null : skinColor.trim();
    }


    public String getHrNo() {
        return hrNo;
    }


    public void setHrNo(String hrNo) {
        this.hrNo = hrNo == null ? null : hrNo.trim();
    }


    public String getSystemNo() {
        return systemNo;
    }


    public void setSystemNo(String systemNo) {
        this.systemNo = systemNo == null ? null : systemNo.trim();
    }


    public Date getEntryDate() {
        return entryDate;
    }


    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }


    public String getSecLevel() {
        return secLevel;
    }


    public void setSecLevel(String secLevel) {
        this.secLevel = secLevel == null ? null : secLevel.trim();
    }


    public String getLoginOrgNo() {
        return loginOrgNo;
    }


    public void setLoginOrgNo(String loginOrgNo) {
        this.loginOrgNo = loginOrgNo == null ? null : loginOrgNo.trim();
    }


    public String getReceiveSms() {
        return receiveSms;
    }


    public void setReceiveSms(String receiveSms) {
        this.receiveSms = receiveSms == null ? null : receiveSms.trim();
    }


    public String getShowMobile() {
        return showMobile;
    }


    public void setShowMobile(String showMobile) {
        this.showMobile = showMobile == null ? null : showMobile.trim();
    }


    public BigDecimal getTotalSortNo() {
        return totalSortNo;
    }


    public void setTotalSortNo(BigDecimal totalSortNo) {
        this.totalSortNo = totalSortNo;
    }


    public String getDeanMac() {
        return deanMac;
    }


    public void setDeanMac(String deanMac) {
        this.deanMac = deanMac == null ? null : deanMac.trim();
    }


    public String getDeanFlag() {
        return deanFlag;
    }


    public void setDeanFlag(String deanFlag) {
        this.deanFlag = deanFlag == null ? null : deanFlag.trim();
    }
}
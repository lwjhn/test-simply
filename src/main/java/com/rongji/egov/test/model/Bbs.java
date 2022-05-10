package com.rongji.egov.test.model;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.rongji.egov.mybatis.base.annotation.*;
import com.rongji.egov.utils.mybatis.typehandler.JsonTypeHandler;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Table(value = "EGOV_BBS", dac = true)
public class Bbs implements Serializable {

    private String id;

    private String content;

    private String subject;

    private String draftDeptNo;

    private String draftDept;

    @Editor(ACL.USER)
    private String draftUserNo;

    private String draftUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishDate;

    @Column("PUBLISH_CATEGORY")
    private String pubCategory;


    @Column("PUBLISH_CATEGORY_NAME")
    private String pubCategoryName;

    @Column(exist = false)
    private String publishCycle;

    @Column(exist = false)
    private String docSequence;
    @Column(exist = false)
    private String isTop;

    @TypeHandler(value = JsonTypeHandler.class)
    @Reader
    private Set<String> publishReaders;

    @TypeHandler(value = JsonTypeHandler.class)
    private Set<String> publishReadersName;

    @Column(exist = false)
    private String remark;

    private String status;

    private String systemNo;
    @Column(exist = false)
    private String queryReaders;
    @Column(exist = false)
    private String currentUserUnitNo;
    @Column(exist = false)
    private String title;

    @Column(exist = false)
    @TypeHandler(value = JsonTypeHandler.class)
    private String[] groupList;

    @Column(exist = false)
    @TypeHandler(value = JsonTypeHandler.class)
    private JSONObject previewParam;
    @Column(exist = false)
    private String currentDate;

    @Column(exist = false)
    private String treeId;

    @Column(exist = false)
    private String treeName;

    @Column(exist = false)
    private String treePid;

    @Column(exist = false)
    private boolean treeDisabled;

    @Column(exist = false)
    private String queryYear;
    @Column(exist = false)
    private String queryMouth;

    @Column(exist = false)
    private String docMarkNo;
    @Column(exist = false)
    private String docWord;
    @Column(exist = false)
    private String docMark;
    @Column(exist = false)
    private Integer docMarkNum;
    @Column(exist = false)
    private Integer docMarkYear;
    @Column(exist = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date serialNumDate;
    @Column(exist = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date issuedDate;


    private String secretLevel;

    private String needApply;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date discardDate;
    @Column(exist = false)
    private Set<String> approveUserNo;
    @Column(exist = false)
    private Set<String> approveUser;
    @Column(exist = false)
    private String approveUserName;
    @Column(exist = false)
    private String isPublishToZWW;

    @Column(exist = false)
    private String searchBeginDate;
    @Column(exist = false)
    private String searchEndDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDraftDeptNo() {
        return draftDeptNo;
    }

    public void setDraftDeptNo(String draftDeptNo) {
        this.draftDeptNo = draftDeptNo;
    }

    public String getDraftDept() {
        return draftDept;
    }

    public void setDraftDept(String draftDept) {
        this.draftDept = draftDept;
    }

    public String getDraftUserNo() {
        return draftUserNo;
    }

    public void setDraftUserNo(String draftUserNo) {
        this.draftUserNo = draftUserNo;
    }

    public String getDraftUser() {
        return draftUser;
    }

    public void setDraftUser(String draftUser) {
        this.draftUser = draftUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getPubCategory() {
        return pubCategory;
    }

    public void setPubCategory(String pubCategory) {
        this.pubCategory = pubCategory;
    }

    public String getPubCategoryName() {
        return pubCategoryName;
    }

    public void setPubCategoryName(String pubCategoryName) {
        this.pubCategoryName = pubCategoryName;
    }

    public String getPublishCycle() {
        return publishCycle;
    }

    public void setPublishCycle(String publishCycle) {
        this.publishCycle = publishCycle;
    }

    public String getDocSequence() {
        return docSequence;
    }

    public void setDocSequence(String docSequence) {
        this.docSequence = docSequence;
    }

    public Set<String> getPublishReaders() {
        return publishReaders;
    }

    public void setPublishReaders(Set<String> publishReaders) {
        this.publishReaders = publishReaders;
    }

    public Set<String> getPublishReadersName() {
        return publishReadersName;
    }

    public void setPublishReadersName(Set<String> publishReadersName) {
        this.publishReadersName = publishReadersName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSystemNo() {
        return systemNo;
    }

    public void setSystemNo(String systemNo) {
        this.systemNo = systemNo;
    }

    public String getQueryReaders() {
        return queryReaders;
    }

    public void setQueryReaders(String queryReaders) {
        this.queryReaders = queryReaders;
    }

    public String getCurrentUserUnitNo() {
        return currentUserUnitNo;
    }

    public void setCurrentUserUnitNo(String currentUserUnitNo) {
        this.currentUserUnitNo = currentUserUnitNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getGroupList() {
        return groupList;
    }

    public void setGroupList(String[] groupList) {
        this.groupList = groupList;
    }

    public JSONObject getPreviewParam() {
        return previewParam;
    }

    public void setPreviewParam(JSONObject previewParam) {
        this.previewParam = previewParam;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getTreeId() {
        return treeId;
    }

    public void setTreeId(String treeId) {
        this.treeId = treeId;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    public String getTreePid() {
        return treePid;
    }

    public void setTreePid(String treePid) {
        this.treePid = treePid;
    }

    public boolean isTreeDisabled() {
        return treeDisabled;
    }

    public void setTreeDisabled(boolean treeDisabled) {
        this.treeDisabled = treeDisabled;
    }

    public String getQueryYear() {
        return queryYear;
    }

    public void setQueryYear(String queryYear) {
        this.queryYear = queryYear;
    }

    public String getQueryMouth() {
        return queryMouth;
    }

    public void setQueryMouth(String queryMouth) {
        this.queryMouth = queryMouth;
    }

    public String getDocMarkNo() {
        return docMarkNo;
    }

    public void setDocMarkNo(String docMarkNo) {
        this.docMarkNo = docMarkNo;
    }

    public String getDocWord() {
        return docWord;
    }

    public void setDocWord(String docWord) {
        this.docWord = docWord;
    }

    public String getDocMark() {
        return docMark;
    }

    public void setDocMark(String docMark) {
        this.docMark = docMark;
    }

    public Integer getDocMarkNum() {
        return docMarkNum;
    }

    public void setDocMarkNum(Integer docMarkNum) {
        this.docMarkNum = docMarkNum;
    }

    public Integer getDocMarkYear() {
        return docMarkYear;
    }

    public void setDocMarkYear(Integer docMarkYear) {
        this.docMarkYear = docMarkYear;
    }

    public Date getSerialNumDate() {
        return serialNumDate;
    }

    public void setSerialNumDate(Date serialNumDate) {
        this.serialNumDate = serialNumDate;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSecretLevel() {
        return secretLevel;
    }

    public void setSecretLevel(String secretLevel) {
        this.secretLevel = secretLevel;
    }

    public String getNeedApply() {
        return needApply;
    }

    public void setNeedApply(String needApply) {
        this.needApply = needApply;
    }

    public Date getDiscardDate() {
        return discardDate;
    }

    public void setDiscardDate(Date discardDate) {
        this.discardDate = discardDate;
    }

    public Set<String> getApproveUserNo() {
        return approveUserNo;
    }

    public void setApproveUserNo(Set<String> approveUserNo) {
        this.approveUserNo = approveUserNo;
    }

    public Set<String> getApproveUser() {
        return approveUser;
    }

    public void setApproveUser(Set<String> approveUser) {
        this.approveUser = approveUser;
    }

    public String getApproveUserName() {
        return approveUserName;
    }

    public void setApproveUserName(String approveUserName) {
        this.approveUserName = approveUserName;
    }

    public String getIsPublishToZWW() {
        return isPublishToZWW;
    }

    public void setIsPublishToZWW(String isPublishToZWW) {
        this.isPublishToZWW = isPublishToZWW;
    }

    public String getSearchBeginDate() {
        return searchBeginDate;
    }

    public void setSearchBeginDate(String searchBeginDate) {
        this.searchBeginDate = searchBeginDate;
    }

    public String getSearchEndDate() {
        return searchEndDate;
    }

    public void setSearchEndDate(String searchEndDate) {
        this.searchEndDate = searchEndDate;
    }
}

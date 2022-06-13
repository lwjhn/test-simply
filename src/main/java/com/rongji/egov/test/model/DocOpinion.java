package com.rongji.egov.test.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rongji.egov.mybatis.base.annotation.Column;
import com.rongji.egov.mybatis.base.annotation.Table;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.Set;

/**
 * 意见对象
 *
 * @author luzhangfei，lindongmei
 * @version 1.0.0
 */
@Table(value = "EGOV_OPINION")
public class DocOpinion implements Cloneable {
    /**
     * 意见唯一ID
     */
    private String id;
    /**
     * 意见编码
     */
    private String opinionCode;
    /**
     * 意见类型
     */
    private String opinionCodeName;
    /**
     * 意见内容
     */
    private String opinionContent;
    /**
     * 图片意见内容，base64
     */
    private String imageContent;
    /**
     * 填写意见时所在环节
     */
    private String flowSlab;

    /**
     * 关联的主文档ID DOC_ID
     */
    private String docId;

    /**
     * 是否内部意见（0：否 1：是）
     */
    private String isInward;

    /**
     * 是否处室意见（0：否 1：是）
     */
    private String isDeptSign;

    /**
     * 是否电子签名（0：否 1：是）
     */
    @Column(exist = false)
    private String isWebSign;

    /**
     * 是否对齐（0：否 1：是）
     */
    @Column(exist = false)
    private String isAlign;

    /**
     * 签名格式
     * 0 默认姓名
     * 1 部门 姓名
     */
    @Column(exist = false)
    private String signFormat = "0";

    /**
     * 意见是否显示（0：否 1：是）
     */
    private String opinionShow;

    /**
     * 意见人签名图片 base64
     */
    private String opinionUserNameImage;

    /**
     * 意见人名称
     */
    private String opinionUser;
    /**
     * 意见人编码
     */
    private String opinionUserNo;
    /**
     * 意见人部门（组织）名称
     */
    private String opinionDept;
    /**
     * 意见人部门（组织）编码
     */
    private String opinionDeptNo;

    /**
     * 代理人名称
     */
    private String proxyUser;
    /**
     * 代理人编码
     */
    private String proxyUserNo;
    /**
     * 代理人部门（组织）名称
     */
    private String proxyDept;
    /**
     * 代理人部门（组织）编码
     */
    private String proxyDeptNo;

    /**
     * 意见实际操作人列表。
     * 例如：在意见管理中添加一个普通意见，由于普通意见无代理人，实际填写人员无法查询。添加此字段进行判断。
     */
    @Column(exist = false)
    private Set<String> writeUserNos;

    /**
     * 意见填写时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 意见修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateTime;

    /**
     * 意见代理类型
     * 普通：0
     * 代登：1
     * 补登：2
     * 代理：3
     * com.rongji.egov.opinion.service.constant.DocOpinionConstant
     */
    private String agentStatus;
    /**
     * 意见所属模块
     */
    @ApiModelProperty(value = "意见所属模块")
    private String moduleId;

    /**
     * 统一部署所属系统编码
     */
    private String systemNo;

    /**
     * 用户排序号
     */
    private String userSortNo;
    /**
     * 扩展字段
     */
    private String extension;

    /**
     * 用户在组织中的排序号
     */
    @Column(exist = false)
    private String uoSortNo;

    /**
     * 用户组织排序号
     */
    @Column(exist = false)
    private String orgSortNo;

    /**
     * 主机登录IP
     */
    @Column(exist = false)
    private String loginIp;

    /**
     * 填写意见时主机唯一标识符
     */
    @Column(exist = false)
    private String machineKey;

    public String getOpinionUserNameImage() {
        return opinionUserNameImage;
    }

    public void setOpinionUserNameImage(String opinionUserNameImage) {
        this.opinionUserNameImage = opinionUserNameImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpinionCode() {
        return opinionCode;
    }

    public void setOpinionCode(String opinionCode) {
        this.opinionCode = opinionCode;
    }

    public String getOpinionCodeName() {
        return opinionCodeName;
    }

    public void setOpinionCodeName(String opinionCodeName) {
        this.opinionCodeName = opinionCodeName;
    }

    public String getOpinionContent() {
        return opinionContent;
    }

    public void setOpinionContent(String opinionContent) {
        this.opinionContent = opinionContent;
    }

    public String getImageContent() {
        return imageContent;
    }

    public void setImageContent(String imageContent) {
        this.imageContent = imageContent;
    }

    public String getFlowSlab() {
        return flowSlab;
    }

    public void setFlowSlab(String flowSlab) {
        this.flowSlab = flowSlab;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getIsInward() {
        return isInward;
    }

    public void setIsInward(String isInward) {
        this.isInward = isInward;
    }

    public String getIsDeptSign() {
        return isDeptSign;
    }

    public void setIsDeptSign(String isDeptSign) {
        this.isDeptSign = isDeptSign;
    }

    public String getIsWebSign() {
        return isWebSign;
    }

    public void setIsWebSign(String isWebSign) {
        this.isWebSign = isWebSign;
    }

    public String getIsAlign() {
        return isAlign;
    }

    public void setIsAlign(String isAlign) {
        this.isAlign = isAlign;
    }

    public String getSignFormat() {
        return signFormat;
    }

    public void setSignFormat(String signFormat) {
        this.signFormat = signFormat;
    }

    public String getOpinionShow() {
        return opinionShow;
    }

    public void setOpinionShow(String opinionShow) {
        this.opinionShow = opinionShow;
    }

    public String getOpinionUser() {
        return opinionUser;
    }

    public void setOpinionUser(String opinionUser) {
        this.opinionUser = opinionUser;
    }

    public String getOpinionUserNo() {
        return opinionUserNo;
    }

    public void setOpinionUserNo(String opinionUserNo) {
        this.opinionUserNo = opinionUserNo;
    }

    public String getOpinionDept() {
        return opinionDept;
    }

    public void setOpinionDept(String opinionDept) {
        this.opinionDept = opinionDept;
    }

    public String getOpinionDeptNo() {
        return opinionDeptNo;
    }

    public void setOpinionDeptNo(String opinionDeptNo) {
        this.opinionDeptNo = opinionDeptNo;
    }

    public String getProxyUser() {
        return proxyUser;
    }

    public void setProxyUser(String proxyUser) {
        this.proxyUser = proxyUser;
    }

    public String getProxyUserNo() {
        return proxyUserNo;
    }

    public void setProxyUserNo(String proxyUserNo) {
        this.proxyUserNo = proxyUserNo;
    }

    public String getProxyDept() {
        return proxyDept;
    }

    public void setProxyDept(String proxyDept) {
        this.proxyDept = proxyDept;
    }

    public String getProxyDeptNo() {
        return proxyDeptNo;
    }

    public void setProxyDeptNo(String proxyDeptNo) {
        this.proxyDeptNo = proxyDeptNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getAgentStatus() {
        return agentStatus;
    }

    public void setAgentStatus(String agentStatus) {
        this.agentStatus = agentStatus;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getSystemNo() {
        return systemNo;
    }

    public void setSystemNo(String systemNo) {
        this.systemNo = systemNo;
    }

    public String getUserSortNo() {
        return userSortNo;
    }

    public void setUserSortNo(String userSortNo) {
        this.userSortNo = userSortNo;
    }

    public String getUoSortNo() {
        return uoSortNo;
    }

    public void setUoSortNo(String uoSortNo) {
        this.uoSortNo = uoSortNo;
    }

    public String getOrgSortNo() {
        return orgSortNo;
    }

    public void setOrgSortNo(String orgSortNo) {
        this.orgSortNo = orgSortNo;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getMachineKey() {
        return machineKey;
    }

    public void setMachineKey(String machineKey) {
        this.machineKey = machineKey;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Set<String> getWriteUserNos() {
        return writeUserNos;
    }

    public void setWriteUserNos(Set<String> writeUserNos) {
        this.writeUserNos = writeUserNos;
    }

    @Override
    public DocOpinion clone() {
        DocOpinion o = null;
        try {
            o = (DocOpinion) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }
}

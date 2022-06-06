package com.rongji.egov.test.model;

import com.rongji.egov.mybatis.base.annotation.Column;
import com.rongji.egov.mybatis.base.annotation.Table;
import com.rongji.egov.mybatis.base.annotation.TypeHandler;
import com.rongji.egov.mybatis.base.wrapper.JsonTypeHandler;
import com.rongji.egov.user.model.enums.RmsResourceTypeEnum;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Author: lwjhn
 * Date: 2022/6/2 15:32
 * Description:
 */
@SuppressWarnings("unused")
@Table("RMS_RESOURCE")
public class RmsResource implements Serializable {
    @Column(exist = false)
    private static final long serialVersionUID = 1L;
    private String id;
    private Integer sortNo;
    private String resourceNo;
    private String resourceName;
    private RmsResourceTypeEnum resourceType;
    private String isLock;
    private String logo;
    private String parentNo;
    private String resourceUrl;
    private String remark;
    private String isTargetWin;
    private String componentPath;
    private String routePath;
    private String isNav;
    private String badgeUrl;
    private String systemNo;

    @TypeHandler(JsonTypeHandler.class)
    private Set<String> roleNos;
    private boolean shortcut;
    private String isAuth;
    private Date createTime;
    private Date modifyTime;

    @Column(exist = false)
    private List<String> ids;
    private String tableOpenType;
    private Boolean lazy;
    private String lazyUrl;
    private Boolean lazyReplace;

    @Column(exist = false)
    private Set<String> orgNos;
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public String getResourceNo() {
        return resourceNo;
    }

    public void setResourceNo(String resourceNo) {
        this.resourceNo = resourceNo;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public RmsResourceTypeEnum getResourceType() {
        return resourceType;
    }

    public void setResourceType(RmsResourceTypeEnum resourceType) {
        this.resourceType = resourceType;
    }

    public String getIsLock() {
        return isLock;
    }

    public void setIsLock(String isLock) {
        this.isLock = isLock;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getParentNo() {
        return parentNo;
    }

    public void setParentNo(String parentNo) {
        this.parentNo = parentNo;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIsTargetWin() {
        return isTargetWin;
    }

    public void setIsTargetWin(String isTargetWin) {
        this.isTargetWin = isTargetWin;
    }

    public String getComponentPath() {
        return componentPath;
    }

    public void setComponentPath(String componentPath) {
        this.componentPath = componentPath;
    }

    public String getRoutePath() {
        return routePath;
    }

    public void setRoutePath(String routePath) {
        this.routePath = routePath;
    }

    public String getIsNav() {
        return isNav;
    }

    public void setIsNav(String isNav) {
        this.isNav = isNav;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    public String getSystemNo() {
        return systemNo;
    }

    public void setSystemNo(String systemNo) {
        this.systemNo = systemNo;
    }

    public Set<String> getRoleNos() {
        return roleNos;
    }

    public void setRoleNos(Set<String> roleNos) {
        this.roleNos = roleNos;
    }

    public boolean isShortcut() {
        return shortcut;
    }

    public void setShortcut(boolean shortcut) {
        this.shortcut = shortcut;
    }

    public String getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(String isAuth) {
        this.isAuth = isAuth;
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

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public String getTableOpenType() {
        return tableOpenType;
    }

    public void setTableOpenType(String tableOpenType) {
        this.tableOpenType = tableOpenType;
    }

    public Boolean getLazy() {
        return lazy;
    }

    public void setLazy(Boolean lazy) {
        this.lazy = lazy;
    }

    public String getLazyUrl() {
        return lazyUrl;
    }

    public void setLazyUrl(String lazyUrl) {
        this.lazyUrl = lazyUrl;
    }

    public Boolean getLazyReplace() {
        return lazyReplace;
    }

    public void setLazyReplace(Boolean lazyReplace) {
        this.lazyReplace = lazyReplace;
    }

    public Set<String> getOrgNos() {
        return orgNos;
    }

    public void setOrgNos(Set<String> orgNos) {
        this.orgNos = orgNos;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

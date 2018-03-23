package com.gw.seckill.facade.admin.entity;

import com.gw.seckill.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class SysResource extends BaseEntity implements Serializable {
    @Column(name = "RES_NAME")
    private String resName;

    @Column(name = "RES_TYPE")
    private String resType;

    @Column(name = "RES_URL")
    private String resUrl;

    @Column(name = "PARENT_ID")
    private Long parentId;

    @Column(name = "PARENT_IDS")
    private String parentIds;

    @Column(name = "PERMISSION")
    private String permission;

    @Column(name = "AVAILABLE")
    private Byte available;

    public SysResource() {
    }

    public SysResource(Long parentId) {

        this.parentId = parentId;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName == null ? null : resName.trim();
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType == null ? null : resType.trim();
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl == null ? null : resUrl.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds == null ? null : parentIds.trim();
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public Byte getAvailable() {
        return available;
    }

    public void setAvailable(Byte available) {
        this.available = available;
    }
}
package com.gw.seckill.facade.admin.entity;

import com.gw.seckill.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class SysRole extends BaseEntity implements Serializable {

    @Column(name = "ROLE")
    private String role;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "RESOURCE_IDS")
    private String resourceIds;

    @Column(name = "AVAILABLE")
    private Byte available;


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds == null ? null : resourceIds.trim();
    }

    public Byte getAvailable() {
        return available;
    }

    public void setAvailable(Byte available) {
        this.available = available;
    }
}
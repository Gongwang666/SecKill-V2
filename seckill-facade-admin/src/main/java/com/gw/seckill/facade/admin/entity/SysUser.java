package com.gw.seckill.facade.admin.entity;

import com.gw.seckill.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
@Table(name = "sys_user")
public class SysUser extends BaseEntity implements Serializable {

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASS_WORD")
    private String passWord;

    @Column(name = "SALT")
    private String salt;

    @Column(name = "ROLE_IDS")
    private String roleIds;

    @Column(name = "LOCKED")
    private Byte locked;

    public SysUser() {
    }

    public SysUser(String userName) {

        this.userName = userName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds == null ? null : roleIds.trim();
    }

    public Byte getLocked() {
        return locked;
    }

    public void setLocked(Byte locked) {
        this.locked = locked;
    }
}
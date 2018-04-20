package com.gw.seckill.facade.admin.entity;

import com.gw.seckill.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
@Table(name = "user")
public class User extends BaseEntity implements Serializable {
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "PASSWORD")
    private String passWord;
    @Column(name = "SALT")
    private String salt;
    @Column(name = "DATA_FLAG")
    private Integer dataFlag;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getDataFlag() {
        return dataFlag;
    }

    public void setDataFlag(Integer dataFlag) {
        this.dataFlag = dataFlag;
    }
}

package com.gw.seckill.facade.admin.entity;

import com.gw.seckill.entity.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

public class GoodsCats extends BaseEntity implements Serializable {
    @Column(name = "PARENT_ID")
    private Long parentId;

    @Column(name = "CAT_NAME")
    private String catName;

    @Column(name = "IS_SHOW")
    private Byte isShow;

    @Column(name = "CAT_SORT")
    private Integer catSort;

    @Column(name = "DATA_FLAG")
    private Byte dataFlag;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "CREATE_TIME")
    private Date createTime;


    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName == null ? null : catName.trim();
    }

    public Byte getIsShow() {
        return isShow;
    }

    public void setIsShow(Byte isShow) {
        this.isShow = isShow;
    }

    public Integer getCatSort() {
        return catSort;
    }

    public void setCatSort(Integer catSort) {
        this.catSort = catSort;
    }

    public Byte getDataFlag() {
        return dataFlag;
    }

    public void setDataFlag(Byte dataFlag) {
        this.dataFlag = dataFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
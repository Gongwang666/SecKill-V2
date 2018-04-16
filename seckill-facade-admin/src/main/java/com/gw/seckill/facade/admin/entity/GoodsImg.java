package com.gw.seckill.facade.admin.entity;

import com.gw.seckill.entity.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
　* @描述:     商品图片
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/3/15 23:22
  */
@Table(name="goods_imgs")
public class GoodsImg extends BaseEntity implements Serializable {
    @Column(name = "IMG_DESC")
    private String imgDesc;
    @Column(name = "IMG_URL")
    private String imgUrl;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "UPLOAD_DATE")
    private Date uploadDate;
    @Column(name = "GOODS_ID")
    private Long goodsID;
    @Column(name = "TYPE")
    private Integer type;

    public Long getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(Long goodsID) {
        this.goodsID = goodsID;
    }

    public String getImgDesc() {
        return imgDesc;
    }

    public void setImgDesc(String imgDesc) {
        this.imgDesc = imgDesc;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}

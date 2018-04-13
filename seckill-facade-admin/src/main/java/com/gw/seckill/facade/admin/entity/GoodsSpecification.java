package com.gw.seckill.facade.admin.entity;

import com.gw.seckill.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
/**
　* @描述:     商品规格VO
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/4/13 14:02
  */
@Table(name="goods_specifications")
public class GoodsSpecification extends BaseEntity implements Serializable {
    @Column(name = "SPEC_NAME")
    private String specName;
    @Column(name = "GOODS_ID")
    private Long goodsId;

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}

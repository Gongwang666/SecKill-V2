package com.gw.seckill.facade.mall.dto;

import com.gw.seckill.facade.admin.entity.GoodsSpecificationItem;

import java.io.Serializable;
import java.util.List;

/**
　* @描述:     商品规格信息dto
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/4/13 14:15
  */
public class DTOSpecInfo implements Serializable {
    private Long goodsId;
    private Long specId;
    private String specName;
    private List<GoodsSpecificationItem> specItems;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public List<GoodsSpecificationItem> getSpecItems() {
        return specItems;
    }

    public void setSpecItems(List<GoodsSpecificationItem> specItems) {
        this.specItems = specItems;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }
}

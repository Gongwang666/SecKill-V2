package com.gw.seckill.facade.mall.dto;

import com.gw.seckill.facade.admin.entity.Goods;

import java.io.Serializable;
import java.util.List;

public class DTOGoodsInfo implements Serializable {
    private String title;
    private String desc;
    private List<Goods> hot;
    private List<Goods> newGoods;
    private List<Goods> goodsInfo;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Goods> getHot() {
        return hot;
    }

    public void setHot(List<Goods> hot) {
        this.hot = hot;
    }

    public List<Goods> getNewGoods() {
        return newGoods;
    }

    public void setNewGoods(List<Goods> newGoods) {
        this.newGoods = newGoods;
    }

    public List<Goods> getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(List<Goods> goodsInfo) {
        this.goodsInfo = goodsInfo;
    }
}

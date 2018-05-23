package com.gw.seckill.facade.mall.entity;

import com.gw.seckill.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name="shop_cart_items")
public class CartItems extends BaseEntity implements Serializable {
    @Column(name = "GOODS_ID")
    private Integer goodsId;
    @Column(name = "GOODS_SPEC_ITEM_ID")
    private Integer goodsSpecItemId;
    @Column(name = "GOODS_NUM")
    private Integer goodsNum;
    @Column(name = "SUM_MONEY")
    private Double sumMoney;
    @Column(name = "CART_ID")
    private Long cartId;

    public Integer getGoodsSpecItemId() {
        return goodsSpecItemId;
    }

    public void setGoodsSpecItemId(Integer goodsSpecItemId) {
        this.goodsSpecItemId = goodsSpecItemId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Double getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(Double sumMoney) {
        this.sumMoney = sumMoney;
    }


    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }
}

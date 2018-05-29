package com.gw.seckill.facade.mall.entity;

import com.gw.seckill.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name="order_items")
public class OrderItems extends BaseEntity implements Serializable {
    @Column(name = "GOODS_ID")
    private Long goodsId;
    @Column(name = "GOODS_NUM")
    private Integer goodsNum;
    @Column(name = "SUM_MONEY")
    private Double sumMoney;
    @Column(name = "DATE")
    private Date orderTime;
    @Column(name = "SIGN")
    private Integer sign;
    @Column(name = "ORDER_ID")
    private Long orderId;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
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

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}

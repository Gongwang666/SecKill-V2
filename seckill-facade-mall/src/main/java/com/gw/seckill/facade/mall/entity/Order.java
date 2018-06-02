package com.gw.seckill.facade.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gw.seckill.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name="orders")
public class Order extends BaseEntity implements Serializable {
    @Column(name = "USER_ID")
    private Integer userId;
    @Column(name = "ORDER_UUID")
    private String orderUUID;
    @Column(name = "SIGN")
    private Integer sign;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "DATE")
    private Date orderTime;
    @Column(name = "TOTAL_MONEY")
    private Double totalMoney;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderUUID() {
        return orderUUID;
    }

    public void setOrderUUID(String orderUUID) {
        this.orderUUID = orderUUID;
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }
}

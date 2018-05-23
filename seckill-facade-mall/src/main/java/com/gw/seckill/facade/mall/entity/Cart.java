package com.gw.seckill.facade.mall.entity;

import com.gw.seckill.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name="shop_cart")
public class Cart extends BaseEntity implements Serializable {
    @Column(name = "USER_ID")
    private Integer userId;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}

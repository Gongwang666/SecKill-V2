package com.gw.seckill.facade.mall.entity;

import com.gw.seckill.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name="order")
public class Order extends BaseEntity implements Serializable {
    @Column(name = "USER_ID")
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

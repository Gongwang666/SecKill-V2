package com.gw.seckill.facade.mall.dto;

import com.gw.seckill.facade.admin.entity.Goods;
import com.gw.seckill.facade.mall.entity.OrderItems;

import java.io.Serializable;

public class DTOOrderItems implements Serializable {
    private Goods goods;
    private OrderItems orderItems;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public OrderItems getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(OrderItems orderItems) {
        this.orderItems = orderItems;
    }
}

package com.gw.seckill.facade.mall.dto;

import com.gw.seckill.facade.mall.entity.Order;

import java.io.Serializable;
import java.util.List;

public class DTOOrder implements Serializable {
    private Order order;
    private List<DTOOrderItems> dtoOrderItemsList;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<DTOOrderItems> getDtoOrderItemsList() {
        return dtoOrderItemsList;
    }

    public void setDtoOrderItemsList(List<DTOOrderItems> dtoOrderItemsList) {
        this.dtoOrderItemsList = dtoOrderItemsList;
    }
}

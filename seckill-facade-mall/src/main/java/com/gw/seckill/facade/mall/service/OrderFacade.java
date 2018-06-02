package com.gw.seckill.facade.mall.service;

import com.gw.seckill.facade.mall.dto.DTOOrder;
import com.gw.seckill.facade.mall.dto.DTOOrderInfo;

import java.util.List;

public interface OrderFacade {
    Integer addToOrder(DTOOrderInfo orderInfo,Integer userId);

    List<DTOOrder> getUnPayOrders(Long userId);
}

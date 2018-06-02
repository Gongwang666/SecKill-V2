package com.gw.seckill.facade.mall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gw.seckill.facade.mall.dto.DTOOrder;
import com.gw.seckill.facade.mall.dto.DTOOrderInfo;
import com.gw.seckill.facade.mall.service.OrderFacade;
import com.gw.seckill.service.mall.biz.OrderBiz;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0")
public class OrderFacadeImpl implements OrderFacade {
    @Autowired
    private OrderBiz orderBiz;

    @Override
    public Integer addToOrder(DTOOrderInfo orderInfo,Integer userId) {
        return orderBiz.addToOrder(orderInfo,userId);
    }

    @Override
    public List<DTOOrder> getUnPayOrders(Long userId) {
        return orderBiz.getUnPayOrders(userId);
    }
}

package com.gw.seckill.service.mall.biz;

import com.gw.seckill.service.mall.dao.OrderItemsMapper;
import com.gw.seckill.service.mall.dao.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderBiz")
public class OrderBiz {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemsMapper orderItemsMapper;
}

package com.gw.seckill.facade.mall.service.impl;

import com.gw.seckill.facade.mall.service.OrderFacade;
import com.gw.seckill.service.mall.biz.OrderBiz;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderFacadeImpl implements OrderFacade {
    @Autowired
    private OrderBiz orderBiz;
}

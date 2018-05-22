package com.gw.seckill.facade.mall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gw.seckill.facade.mall.entity.Cart;
import com.gw.seckill.facade.mall.service.CartFacade;
import com.gw.seckill.service.mall.biz.CartBiz;
import org.springframework.beans.factory.annotation.Autowired;
@Service(version = "1.0.0")
public class CartFacadeImpl implements CartFacade {
    @Autowired
    private CartBiz cartBiz;

    @Override
    public int addGoodsToCart(Cart cart) {
        return cartBiz.addGoodsToCart(cart);
    }
}

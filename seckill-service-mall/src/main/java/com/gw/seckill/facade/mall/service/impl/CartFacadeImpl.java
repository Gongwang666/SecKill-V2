package com.gw.seckill.facade.mall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gw.seckill.facade.mall.dto.DTOCartInfo;
import com.gw.seckill.facade.mall.entity.CartItems;
import com.gw.seckill.facade.mall.service.CartFacade;
import com.gw.seckill.service.mall.biz.CartBiz;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0")
public class CartFacadeImpl implements CartFacade {
    @Autowired
    private CartBiz cartBiz;

    @Override
    public int addGoodsToCart(Long userId,CartItems cartItems) {
        return cartBiz.addGoodsToCart(userId,cartItems);
    }

    @Override
    public List<DTOCartInfo> getCartInfo(Integer userId) {
        return cartBiz.getCartInfo(userId);
    }

    @Override
    public void deleteCatItem(Long id) {
        cartBiz.deleteCatItem(id);
    }
}

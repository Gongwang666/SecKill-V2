package com.gw.seckill.facade.mall.service;

import com.gw.seckill.facade.mall.dto.DTOCartInfo;
import com.gw.seckill.facade.mall.entity.CartItems;

public interface CartFacade {
    int addGoodsToCart(Long userId,CartItems cartItems);
    DTOCartInfo getCartInfo(Integer userId);
}

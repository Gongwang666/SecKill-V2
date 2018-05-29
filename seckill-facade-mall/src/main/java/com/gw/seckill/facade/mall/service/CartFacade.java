package com.gw.seckill.facade.mall.service;

import com.gw.seckill.facade.mall.dto.DTOCartInfo;
import com.gw.seckill.facade.mall.entity.CartItems;

import java.util.List;

public interface CartFacade {
    int addGoodsToCart(Long userId,CartItems cartItems);
    List<DTOCartInfo> getCartInfo(Integer userId);

    void deleteCatItem(Long id);
}

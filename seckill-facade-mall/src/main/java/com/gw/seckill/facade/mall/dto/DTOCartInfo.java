package com.gw.seckill.facade.mall.dto;

import com.gw.seckill.facade.admin.entity.Goods;
import com.gw.seckill.facade.mall.entity.CartItems;

import java.io.Serializable;

public class DTOCartInfo implements Serializable {
    private Goods goodsInfo;
    private CartItems cartItems;

    public Goods getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(Goods goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public CartItems getCartItems() {
        return cartItems;
    }

    public void setCartItems(CartItems cartItems) {
        this.cartItems = cartItems;
    }
}

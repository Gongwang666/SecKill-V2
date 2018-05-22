package com.gw.seckill.service.mall.biz;

import com.gw.seckill.facade.mall.entity.Cart;
import com.gw.seckill.service.mall.dao.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cartBiz")
public class CartBiz {
    @Autowired
    private CartMapper cartMapper;

    public int addGoodsToCart(Cart cart){
        return cartMapper.insert(cart);
    }
}

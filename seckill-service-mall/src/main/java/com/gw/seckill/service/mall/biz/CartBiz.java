package com.gw.seckill.service.mall.biz;


import com.gw.seckill.core.admin.dao.GoodsMapper;
import com.gw.seckill.facade.admin.entity.Goods;
import com.gw.seckill.facade.mall.dto.DTOCartInfo;
import com.gw.seckill.facade.mall.entity.Cart;
import com.gw.seckill.facade.mall.entity.CartItems;
import com.gw.seckill.service.mall.dao.CartItemsMapper;
import com.gw.seckill.service.mall.dao.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cartBiz")
public class CartBiz {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private CartItemsMapper cartItemsMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Transactional
    public int addGoodsToCart(Long userId,CartItems cartItems){
        Cart cart = new Cart();
        cart.setUserId(userId.intValue());
        Cart cartInfo = cartMapper.selectOne(cart);
        Long cartId = null;
        if(cartInfo==null){
            cartMapper.insert(cart);
            cart = cartMapper.selectOne(cart);
            cartId = cart.getId();
        }else{
            cartId = cartInfo.getId();
        }
        Goods goodsInfo = goodsMapper.selectByPrimaryKey((long)cartItems.getGoodsId());
        Double sumMoney = (double)goodsInfo.getShopPrice()*cartItems.getGoodsNum();
        cartItems.setSumMoney(sumMoney);
        cartItems.setCartId(cartId);
        return cartItemsMapper.insert(cartItems);
    }

    public DTOCartInfo getCartInfo(Integer userId) {
        DTOCartInfo dtoCartInfo = new DTOCartInfo();
        return dtoCartInfo;
    }
}

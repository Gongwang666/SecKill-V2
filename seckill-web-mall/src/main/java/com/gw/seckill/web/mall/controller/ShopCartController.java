package com.gw.seckill.web.mall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gw.seckill.common.web.exception.pojo.Result;
import com.gw.seckill.facade.mall.entity.Cart;
import com.gw.seckill.facade.mall.service.CartFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ShopCartController {
    @Reference(version = "1.0.0")
    private CartFacade cartFacade;
    @RequestMapping("/cart")
    public ModelAndView cartPage(){
        ModelAndView mo = new ModelAndView();
        mo.setViewName("/pages/shopcart");
        return mo;
    }
    @RequestMapping("/addGoodsToCart")
    public Result addGoodsToCart(){
        Result result = new Result();
        Cart cart = new Cart();
        cart.setGoodsId(1);
        cart.setGoodsNum(2);
        cart.setGoodsSpecItemId(1);
        cart.setSumMoney((double)1000);
        cart.setTotalMoney((double)2000);
        cartFacade.addGoodsToCart(cart);
        return result;
    }
}

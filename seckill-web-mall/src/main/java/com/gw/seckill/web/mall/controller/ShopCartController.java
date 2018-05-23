package com.gw.seckill.web.mall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gw.seckill.common.web.exception.pojo.Result;
import com.gw.seckill.facade.admin.entity.User;
import com.gw.seckill.facade.mall.entity.CartItems;
import com.gw.seckill.facade.mall.service.CartFacade;
import org.apache.shiro.SecurityUtils;
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
    public Result addGoodsToCart(CartItems cartItems){
        Result result = new Result();
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        cartFacade.addGoodsToCart(user.getId(),cartItems);
        return result;
    }
}

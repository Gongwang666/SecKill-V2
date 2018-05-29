package com.gw.seckill.web.mall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gw.seckill.common.web.exception.pojo.Result;
import com.gw.seckill.facade.admin.entity.User;
import com.gw.seckill.facade.mall.dto.DTOCartInfo;
import com.gw.seckill.facade.mall.entity.CartItems;
import com.gw.seckill.facade.mall.service.CartFacade;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    @RequestMapping("/getCartInfo")
    public List<DTOCartInfo> getCartInfo(){
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        if(user == null){
            return null;
        }
        List<DTOCartInfo> list = cartFacade.getCartInfo(user.getId().intValue());
        return list;
    }
    @RequestMapping("/deleteCatItem")
    public List<DTOCartInfo> deleteCatItem(Long id){
        cartFacade.deleteCatItem(id);
        return getCartInfo();
    }
}

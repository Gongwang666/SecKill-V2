package com.gw.seckill.web.mall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gw.seckill.facade.mall.service.QueryGoodsInfoFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GoodsListPageController {
    @Reference(version = "1.0.0")
    private QueryGoodsInfoFacade queryGoodsInfoFacade;

    @RequestMapping("/goodsList")
    public ModelAndView goodsListPage(){
        ModelAndView mo = new ModelAndView();
        mo.setViewName("/pages/search");
        return mo;
    }
}

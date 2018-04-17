package com.gw.seckill.web.mall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gw.seckill.facade.admin.entity.Goods;
import com.gw.seckill.facade.mall.service.QueryGoodsInfoFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class GoodsListPageController {
    @Reference(version = "1.0.0")
    private QueryGoodsInfoFacade queryGoodsInfoFacade;

    @RequestMapping("/goodsList")
    public ModelAndView goodsListPage(@RequestParam Long catId){
        ModelAndView mo = new ModelAndView();
        mo.setViewName("/pages/search");
        return mo;
    }

    @RequestMapping("/goodsList/queryGoods")
    public List<Goods> queryGoods(@RequestParam Integer catId){
        return queryGoodsInfoFacade.queryGoodsByCatId(catId);
    }
}

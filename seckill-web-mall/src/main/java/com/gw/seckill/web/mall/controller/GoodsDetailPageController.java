package com.gw.seckill.web.mall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gw.seckill.facade.admin.entity.Goods;
import com.gw.seckill.facade.mall.service.QueryGoodsInfoFacade;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GoodsDetailPageController {
    @Reference(version = "1.0.0")
    private QueryGoodsInfoFacade queryGoodsInfoFacade;

    @RequestMapping("/introduction")
    public ModelAndView introductionPage(@RequestParam Long goodsId){
        ModelAndView mo = new ModelAndView();
        mo.addObject("id",goodsId);
        mo.setViewName("/pages/introduction");
        return mo;
    }


    @RequestMapping("/introduction/getGoodsInfo")
    public Goods getGoodsInfo(Long id){
        return queryGoodsInfoFacade.getGoodsInfoById(id);
    }
}

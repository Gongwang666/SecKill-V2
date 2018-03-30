package com.gw.seckill.web.mall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gw.seckill.facade.admin.entity.GoodsCats;
import com.gw.seckill.facade.admin.service.GoodsCatsFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class SalePageController {
    @Reference(version = "1.0.0")
    private GoodsCatsFacade goodsCatsFacade;
    @RequestMapping("/home")
    public ModelAndView homePage(){
        ModelAndView mo = new ModelAndView();
        mo.setViewName("/pages/home");
        return mo;
    }
    @RequestMapping("/introduction")
    public ModelAndView introductionPage(){
        ModelAndView mo = new ModelAndView();
        mo.setViewName("/pages/introduction");
        return mo;
    }
    @RequestMapping("/getCatList")
    public List<GoodsCats> getCatList(){
        List<GoodsCats> list = goodsCatsFacade.getGoodsCatsTree();
        return list;
    }
}

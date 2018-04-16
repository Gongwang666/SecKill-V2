package com.gw.seckill.web.mall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gw.seckill.facade.admin.entity.Goods;
import com.gw.seckill.facade.admin.entity.GoodsImg;
import com.gw.seckill.facade.mall.dto.DTOSpecInfo;
import com.gw.seckill.facade.mall.service.QueryGoodsInfoFacade;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    /**
    　* @描述:     获取商品规格信息
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/4/13 16:23
      */
    @RequestMapping("/introduction/getSpecInfo")
    public DTOSpecInfo getSpecInfo(Long id){
        return queryGoodsInfoFacade.getSpecInfoByGoodsId(id);
    }
    /**
    　* @描述:     查询商品详情图片
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/4/16 18:40
      */
    @RequestMapping("/introduction/getDetailImgs")
    public List<GoodsImg> getDetailImgs(Long id){
        return queryGoodsInfoFacade.queryGoodsDetailImgs(id);
    }
}

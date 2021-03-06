package com.gw.seckill.facade.mall.service;


import com.gw.seckill.facade.admin.entity.Goods;
import com.gw.seckill.facade.admin.entity.GoodsImg;
import com.gw.seckill.facade.mall.dto.DTOGoodsInfo;
import com.gw.seckill.facade.mall.dto.DTOSpecInfo;

import java.util.List;

/**
　* @描述:     查询商品信息接口
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/4/9 17:59
  */
public interface QueryGoodsInfoFacade {
    /**
    　* @描述:     商品首页查询商品信息
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/4/11 18:13
      */
    DTOGoodsInfo getHomePageGoodsList();
    /**
    　* @描述:     通过商品id查询商品信息
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/4/11 18:13
      */
    Goods getGoodsInfoById(Long id);

    /**
    　* @描述:     通过商品id查询其规格信息
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/4/13 14:13
      */

    DTOSpecInfo getSpecInfoByGoodsId(Long goodsId);
    /**
    　* @描述:     获取商品详情图片
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/4/16 18:33
      */
    List<GoodsImg> queryGoodsDetailImgs(Long goodsId);
    /**
    　* @描述:     查询分类下的所有商品
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/4/17 17:04
      */
    List<Goods> queryGoodsByCatId(Integer catId);
}

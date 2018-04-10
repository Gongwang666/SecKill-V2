package com.gw.seckill.facade.mall.service;


import com.gw.seckill.facade.mall.dto.DTOGoodsInfo;

import java.util.List;

/**
　* @描述:     查询商品信息接口
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/4/9 17:59
  */
public interface QueryGoodsInfoFacade {
    DTOGoodsInfo getHomePageGoodsList();
}

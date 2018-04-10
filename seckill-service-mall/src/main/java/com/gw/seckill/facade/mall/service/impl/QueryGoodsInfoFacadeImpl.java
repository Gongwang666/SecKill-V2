package com.gw.seckill.facade.mall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.gw.seckill.facade.admin.entity.Goods;
import com.gw.seckill.facade.mall.dto.DTOGoodsInfo;
import com.gw.seckill.facade.mall.service.QueryGoodsInfoFacade;
import com.gw.seckill.service.mall.biz.QueryGoodsInfoBiz;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0")
public class QueryGoodsInfoFacadeImpl implements QueryGoodsInfoFacade {
    @Autowired
    private QueryGoodsInfoBiz queryGoodsInfoBiz;

    @Override
    public DTOGoodsInfo getHomePageGoodsList() {
        return queryGoodsInfoBiz.getHomePageGoodsList();
    }
}
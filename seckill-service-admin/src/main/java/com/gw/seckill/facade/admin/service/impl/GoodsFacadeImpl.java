package com.gw.seckill.facade.admin.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.gw.seckill.core.admin.biz.GoodsBiz;
import com.gw.seckill.facade.admin.entity.Goods;
import com.gw.seckill.facade.admin.service.GoodsFacade;
import org.springframework.beans.factory.annotation.Autowired;

/**
　* @描述:     商品信息管理dubbo服务实现
　* @参数描述: 
　* @返回值:
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/3/7 10:26
  */
@Service(version = "1.0.0")
public class GoodsFacadeImpl implements GoodsFacade{
    @Autowired
    private GoodsBiz goodsBiz;
    @Override
    public PageInfo<Goods> getAllGoodsPaged(Goods goods) {
        return goodsBiz.getAllGoodsPaged(goods);
    }

    @Override
    public PageInfo<Goods> getAllGoodsPagedWithImgs(Goods goods) {
        return goodsBiz.getAllGoodsPagedWithImgs(goods);
    }

    @Override
    public int addGoods(Goods goods) {
        return goodsBiz.addGoods(goods);
    }

    @Override
    public int setGoodsImgPath(Long id) {
        return goodsBiz.setGoodsImgPath(id);
    }
}

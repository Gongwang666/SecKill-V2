package com.gw.seckill.facade.admin.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.gw.seckill.core.admin.biz.GoodsImgBiz;
import com.gw.seckill.facade.admin.entity.GoodsImg;
import com.gw.seckill.facade.admin.service.GoodsImgFacade;
import org.springframework.beans.factory.annotation.Autowired;

/**
　* @描述:     商品图片服务实现类
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/3/15 23:33
  */
@Service(version = "1.0.0")
public class GoodsImgFacadeImpl implements GoodsImgFacade{
    @Autowired
    private GoodsImgBiz goodsImgBiz;

    @Override
    public int addImg(GoodsImg goodsImg) {
        return goodsImgBiz.addImg(goodsImg);
    }

    @Override
    public PageInfo<GoodsImg> getAllImgPaged(GoodsImg goodsImg) {
        return goodsImgBiz.getAllImgPaged(goodsImg);
    }

    @Override
    public int delImg(Long[] ids) {
        return goodsImgBiz.delImg(ids);
    }

    @Override
    public GoodsImg getImgById(Long id) {
        return goodsImgBiz.getImgById(id);
    }
}

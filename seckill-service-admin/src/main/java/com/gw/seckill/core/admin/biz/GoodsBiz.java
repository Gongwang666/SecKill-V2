package com.gw.seckill.core.admin.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gw.seckill.core.admin.dao.GoodsMapper;
import com.gw.seckill.facade.admin.entity.Goods;
import com.gw.seckill.facade.admin.entity.GoodsImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
　* @描述:     商品信息管理业务类
　* @参数描述: 
　* @返回值:
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/3/7 10:27
  */
@Service("goodsBiz")
public class GoodsBiz {
    @Autowired
    private GoodsMapper goodsDAO;
    @Autowired
    private GoodsImgBiz goodsImgBiz;

    public PageInfo<Goods> getAllGoodsPaged(Goods goods) {
        if (goods.getPage() != null && goods.getRows() != null) {
            PageHelper.startPage(goods.getPage(), goods.getRows());
        }
        return new PageInfo<Goods>(goodsDAO.selectAll());
    }

    public PageInfo<Goods> getAllGoodsPagedWithImgs(Goods goods) {
        if (goods.getPage() != null && goods.getRows() != null) {
            PageHelper.startPage(goods.getPage(), goods.getRows());
        }
        return new PageInfo<Goods>(goodsDAO.selectGoodsWithImg());
    }

    public int addGoods(Goods goods) {
        goods.setGoodsSn(UUID.randomUUID().toString());
        if(goods.getIsSale() == (byte)1){
            goods.setSaleTime(new Date());
        }
        goods.setCreateTime(new Date());
        return goodsDAO.insertSelective(goods);
    }

    public int setGoodsImgPath(Long id) {
        GoodsImg goodsImg = goodsImgBiz.getImgById(id);
        Goods goods = new Goods();
        goods.setId(goodsImg.getGoodsID());
        goods.setGoodsImg(goodsImg.getImgUrl());
        return goodsDAO.updateByPrimaryKeySelective(goods);
    }

    public int delGoods(Long id) {
        Goods goods = new Goods();
        goods.setId(id);
        goods.setDataFlag((byte)0);
        return goodsDAO.updateByPrimaryKeySelective(goods);
    }

    public int enableGoods(Long id) {
        Goods goods = new Goods();
        goods.setId(id);
        goods.setDataFlag((byte)1);
        return goodsDAO.updateByPrimaryKeySelective(goods);
    }

    public int groundingGoods(Long id) {
        Goods goods = new Goods();
        goods.setId(id);
        goods.setSaleTime(new Date());
        goods.setIsSale((byte)1);
        return goodsDAO.updateByPrimaryKeySelective(goods);
    }

    public int pullOff(Long id) {
        Goods goods = new Goods();
        goods.setId(id);
        goods.setIsSale((byte)0);
        return goodsDAO.updateByPrimaryKeySelective(goods);
    }
}

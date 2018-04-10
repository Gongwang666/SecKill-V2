package com.gw.seckill.facade.admin.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.gw.seckill.core.admin.biz.GoodsCatsBiz;
import com.gw.seckill.facade.admin.entity.GoodsCats;
import com.gw.seckill.facade.admin.service.GoodsCatsFacade;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
　* @描述:     商品分类管理Dubbo服务实现
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2017/12/29 11:08
  */
@Service(version = "1.0.0")
public class GoodsCatsFacadeImpl implements GoodsCatsFacade {

    @Autowired
    private GoodsCatsBiz goodsCatsBiz;


    @Override
    public List<GoodsCats> getAllGoodCats() {
        return goodsCatsBiz.getAllGoodCats();
    }

    @Override
    public List<GoodsCats> getGoodsCatsTree() {
        return goodsCatsBiz.getGoodsCatsTree();
    }

    @Override
    public PageInfo<GoodsCats> getAllCatsPaged(GoodsCats goodsCats) {
        return goodsCatsBiz.getAllCatsPaged(goodsCats);
    }

    @Override
    public int addCats(GoodsCats goodsCats) {
        return goodsCatsBiz.addCats(goodsCats);
    }

    @Override
    public int delCat(Long id) {
        return goodsCatsBiz.delCat(id);
    }

    @Override
    public GoodsCats getCatsById(Long id) {
        return goodsCatsBiz.getCatsById(id);
    }

    @Override
    public int editCat(GoodsCats goodsCats) {
        return goodsCatsBiz.editCat(goodsCats);
    }

    @Override
    public int enableCats(Long id) {
        return goodsCatsBiz.enableCats(id);
    }

    @Override
    public List<GoodsCats> getChildList(GoodsCats goodsCats) {
        return goodsCatsBiz.getChildList(goodsCats);
    }

    @Override
    public String getCatIdPath(Long id) {
        return goodsCatsBiz.getCatIdPath(id);
    }

    @Override
    public GoodsCats getCatsByName(String name) {
        return goodsCatsBiz.getCatsByName(name);
    }
}

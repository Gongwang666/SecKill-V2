package com.gw.seckill.service.mall.biz;

import com.gw.seckill.core.admin.biz.GoodsCatsBiz;
import com.gw.seckill.core.admin.dao.GoodsMapper;
import com.gw.seckill.facade.admin.entity.Goods;
import com.gw.seckill.facade.admin.entity.GoodsCats;
import com.gw.seckill.facade.mall.dto.DTOGoodsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service("queryGoodsInfoBiz")
public class QueryGoodsInfoBiz {
    @Autowired
    private GoodsMapper goodsDAO;
    @Autowired
    private GoodsCatsBiz goodsCatsBiz;

    public DTOGoodsInfo getHomePageGoodsList() {
        DTOGoodsInfo infoList = new DTOGoodsInfo();
        GoodsCats goodsCats = goodsCatsBiz.getCatsByName("手机");
        Example hotExample = new Example(Goods.class);
        Example.Criteria hotCriteria = hotExample.createCriteria();
        hotCriteria.andEqualTo("goodsCatId",goodsCats.getId())
                .andEqualTo("isHot",1)
                .andEqualTo("isSale",1);
        List<Goods> hot = goodsDAO.selectByExample(hotExample);

        Example newExample = new Example(Goods.class);
        Example.Criteria newCriteria = newExample.createCriteria();
        newCriteria.andEqualTo("goodsCatId",goodsCats.getId())
                .andEqualTo("isNew",1)
                .andEqualTo("isSale",1);
        List<Goods> newGoods = goodsDAO.selectByExample(newExample);

        Example infoExample = new Example(Goods.class);
        Example.Criteria infoCriteria = infoExample.createCriteria();
        infoExample.orderBy("saleNum").desc();
        infoCriteria.andEqualTo("goodsCatId",goodsCats.getId())
                .andEqualTo("isSale",1);
        List<Goods> goodsInfo = goodsDAO.selectByExample(infoExample);
        infoList.setTitle(goodsCats.getCatName());
        infoList.setHot(hot);
        infoList.setNewGoods(newGoods);
        infoList.setGoodsInfo(goodsInfo);
        return infoList;
    }
}

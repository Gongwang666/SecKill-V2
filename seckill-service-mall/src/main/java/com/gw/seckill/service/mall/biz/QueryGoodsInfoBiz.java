package com.gw.seckill.service.mall.biz;

import com.gw.seckill.core.admin.biz.GoodsCatsBiz;
import com.gw.seckill.core.admin.dao.GoodsImgMapper;
import com.gw.seckill.core.admin.dao.GoodsMapper;
import com.gw.seckill.core.admin.dao.GoodsSpecItemMapper;
import com.gw.seckill.core.admin.dao.GoodsSpecMapper;
import com.gw.seckill.facade.admin.entity.*;
import com.gw.seckill.facade.admin.service.GoodsImgFacade;
import com.gw.seckill.facade.mall.dto.DTOGoodsInfo;
import com.gw.seckill.facade.mall.dto.DTOSpecInfo;
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
    @Autowired
    private GoodsSpecMapper goodsSpecMapper;
    @Autowired
    private GoodsSpecItemMapper goodsSpecItemMapper;
    @Autowired
    private GoodsImgMapper goodsImgMapper;

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

    public Goods getGoodsInfoById(Long id) {
        return goodsDAO.selectByPrimaryKey(id);
    }

    public DTOSpecInfo getSpecInfoByGoodsId(Long goodsId) {
        DTOSpecInfo specInfo = new DTOSpecInfo();
        specInfo.setGoodsId(goodsId);
        GoodsSpecification spec = new GoodsSpecification();
        spec.setGoodsId(goodsId);
        List<GoodsSpecification> specList = goodsSpecMapper.select(spec);
        if(specList!=null&&specList.size()>0){
            for(GoodsSpecification spc:specList){
                specInfo.setSpecId(spc.getId());
                specInfo.setSpecName(spc.getSpecName());
                GoodsSpecificationItem spcItem = new GoodsSpecificationItem();
                spcItem.setSpecId(spc.getId());
                List<GoodsSpecificationItem> itemList =goodsSpecItemMapper.select(spcItem);
                specInfo.setSpecItems(itemList);
            }
        }
        return specInfo;
    }

    public List<GoodsImg> queryGoodsDetailImgs(Long goodsId) {
        GoodsImg goodsImg = new GoodsImg();
        goodsImg.setGoodsID(goodsId);
        goodsImg.setType(1);
        return goodsImgMapper.select(goodsImg);
    }
}

package com.gw.seckill.core.admin.dao;

import com.gw.seckill.common.core.dao.BaseMapper;
import com.gw.seckill.facade.admin.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("goodsDAO")
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
    /*int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);*/

   List<Goods> selectGoodsWithImg();
}
package com.gw.seckill.core.admin.dao;

import com.gw.seckill.common.core.dao.BaseMapper;
import com.gw.seckill.facade.admin.entity.GoodsImg;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("goodsImgDAO")
@Mapper
public interface GoodsImgMapper extends BaseMapper<GoodsImg>{
}

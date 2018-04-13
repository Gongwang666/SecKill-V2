package com.gw.seckill.core.admin.dao;

import com.gw.seckill.common.core.dao.BaseMapper;
import com.gw.seckill.facade.admin.entity.GoodsSpecificationItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("goodsSpecItemDAO")
@Mapper
public interface GoodsSpecItemMapper extends BaseMapper<GoodsSpecificationItem> {
}

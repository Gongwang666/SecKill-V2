package com.gw.seckill.core.admin.dao;

import com.gw.seckill.common.core.dao.BaseMapper;
import com.gw.seckill.facade.admin.entity.GoodsSpecification;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("goodsSpecDAO")
@Mapper
public interface GoodsSpecMapper extends BaseMapper<GoodsSpecification> {
}

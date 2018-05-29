package com.gw.seckill.service.mall.dao;

import com.gw.seckill.common.core.dao.BaseMapper;
import com.gw.seckill.facade.mall.entity.OrderItems;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("orderItemsDAO")
@Mapper
public interface OrderItemsMapper extends BaseMapper<OrderItems> {
}

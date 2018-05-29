package com.gw.seckill.service.mall.dao;

import com.gw.seckill.common.core.dao.BaseMapper;
import com.gw.seckill.facade.mall.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("orderDAO")
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}

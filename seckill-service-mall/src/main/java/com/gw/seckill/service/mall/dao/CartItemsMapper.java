package com.gw.seckill.service.mall.dao;

import com.gw.seckill.common.core.dao.BaseMapper;
import com.gw.seckill.facade.mall.entity.CartItems;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("cartItemsDAO")
@Mapper
public interface CartItemsMapper extends BaseMapper<CartItems> {
}

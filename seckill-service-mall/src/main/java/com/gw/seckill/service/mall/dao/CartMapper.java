package com.gw.seckill.service.mall.dao;

import com.gw.seckill.common.core.dao.BaseMapper;
import com.gw.seckill.facade.admin.entity.User;
import com.gw.seckill.facade.mall.entity.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("cartDAO")
@Mapper
public interface CartMapper extends BaseMapper<Cart> {
}

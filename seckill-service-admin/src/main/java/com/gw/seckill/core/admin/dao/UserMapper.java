package com.gw.seckill.core.admin.dao;

import com.gw.seckill.common.core.dao.BaseMapper;
import com.gw.seckill.facade.admin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
@Mapper
public interface UserMapper extends BaseMapper<User> {
}

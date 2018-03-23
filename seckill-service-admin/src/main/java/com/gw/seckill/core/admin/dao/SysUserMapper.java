package com.gw.seckill.core.admin.dao;

import com.gw.seckill.common.core.dao.BaseMapper;
import com.gw.seckill.facade.admin.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("sysUserDAO")
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    /*int deleteByPrimaryKey(Long sysUserId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long sysUserId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser selectByUserName(String userName);*/
}
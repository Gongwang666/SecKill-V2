package com.gw.seckill.core.admin.dao;

import com.gw.seckill.common.core.dao.BaseMapper;
import com.gw.seckill.facade.admin.entity.SysResource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("sysResourceDAO")
@Mapper
public interface SysResourceMapper extends BaseMapper<SysResource> {
    /*int deleteByPrimaryKey(Long resId);

    int insert(SysResource record);

    int insertSelective(SysResource record);

    SysResource selectByPrimaryKey(Long resId);

    int updateByPrimaryKeySelective(SysResource record);

    int updateByPrimaryKey(SysResource record);*/

    /**
    　* @描述:     通过父id找儿子节点
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/8 16:15
      */
    //List<SysResource> selectSysResByParentId(Long parentId);
    /**
    　* @描述:     获取所有资源节点
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/8 16:27
      */
    //List<SysResource> selectAllRes();
}
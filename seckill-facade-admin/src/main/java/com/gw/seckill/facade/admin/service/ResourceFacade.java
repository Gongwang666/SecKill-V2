package com.gw.seckill.facade.admin.service;

import com.github.pagehelper.PageInfo;
import com.gw.seckill.facade.admin.entity.SysResource;

import java.util.List;

/**
　* @描述:     资源管理服务接口
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/1/12 15:16
  */
public interface ResourceFacade {
    /**
     　* @描述:     删除资源
     　* @参数描述:
     　* @返回值:
     　* @异常:
     　* @作者:     gongwang
     　* @创建时间: 2018/1/10 22:10
     */
    void deleteSysResource(Long resID);
    /**
     　* @描述:     获取所有的资源
     　* @参数描述:
     　* @返回值:
     　* @异常:
     　* @作者:     gongwang
     　* @创建时间: 2018/1/9 21:30
     */
    List<SysResource> getAllResources();
    /**
     　* @描述:     添加资源
     　* @参数描述:
     　* @返回值:
     　* @异常:
     　* @作者:     gongwang
     　* @创建时间: 2018/1/10 16:21
     */
    void addSysRes(SysResource sysResource);
    /**
     * 类名:
     * 参数: 
     * 描述: 通过资源id获取资源
     * 作者: gongwang
     * 日期: 2018/1/24
     * 时间: 下午2:45
     **/
    SysResource getResourcesByID(Long resID);
    /**
     * 类名:
     * 参数: 
     * 描述: 更新资源信息
     * 作者: gongwang
     * 日期: 2018/1/24
     * 时间: 下午2:50
     **/
    int updateResources(SysResource sysResource);
    /**
     * 类名:
     * 参数: 
     * 描述: 启用资源
     * 作者: gongwang
     * 日期: 2018/1/24
     * 时间: 下午5:14
     **/
    int enableRes(Long resId);
    /**
    　* @描述:     分页查询所有资源
    　* @参数描述:
    　* @返回值:
    　* @异常:
    　* @作者:     gongwang
    　* @创建时间: 2018/2/5 16:38
      */
    PageInfo<SysResource> getAllResourcesPaged(SysResource sysResource);
    /**
     * 类名:
     * 参数:
     * 描述: 获取总记录数
     * 作者: gongwang
     * 日期: 2018/2/6
     * 时间: 下午7:41
     **/
    Integer getResTotalCount();
}

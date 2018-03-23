package com.gw.seckill.facade.admin.service;

import com.github.pagehelper.PageInfo;
import com.gw.seckill.facade.admin.entity.SysResource;
import com.gw.seckill.facade.admin.entity.SysUser;

import java.util.List;
import java.util.Set;

/**
　* @描述:     用户登录，权限管理
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/1/5 16:56
  */
public interface UserFacade {
    /**
    　* @描述:     通过用户名查找权限
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/12 14:55
      */
    Set<String> findPermissions(String username);

    /**
    　* @描述:     通过用户名查找账户
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/11 17:03
      */
    SysUser findByAccount(String userName);
    /**
    　* @描述:     通过用户名查找用户可以访问的URL
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/16 18:10
      */
    Set<String> findPermissionUrl(String userName);
    /**
    　* @描述:     添加用户
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/17 21:45
      */
    int addSysUser(SysUser sysUser);
    /**
     * 类名:
     * 参数: 
     * 描述: 获取所有用户
     * 作者: gongwang
     * 日期: 2018/1/26
     * 时间: 下午7:37
     **/
    List<SysUser> getAllUsers();
    /**
     * 类名:
     * 参数: 
     * 描述: 解锁用户
     * 作者: gongwang
     * 日期: 2018/1/26
     * 时间: 下午7:54
     **/
    int deBlockingUser(Long userID);

    /**
     * 类名:
     * 参数: 
     * 描述: 停用用户
     * 作者: gongwang
     * 日期: 2018/1/26
     * 时间: 下午8:35
     **/
    int blockingUser(Long userID);

    /**
     * 类名:
     * 参数: 
     * 描述: 分页查询所有用户
     * 作者: gongwang
     * 日期: 2018/2/8
     * 时间: 下午12:15
     **/
    PageInfo<SysUser> getAllUsersPaged(SysUser sysUser);
}

package com.gw.seckill.facade.admin.service;

import com.github.pagehelper.PageInfo;
import com.gw.seckill.facade.admin.entity.SysRole;

import java.util.List;
import java.util.Set;

/**
　* @描述:     角色管理
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/1/12 15:05
  */
public interface RoleFacade {
    /**
    　* @描述:     根据角色编号得到资源ID列表
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/12 15:11
      */
    Set<Long> findRoleResourceIDs(Long[] roleIds);
    /**
     * 类名:
     * 参数: 
     * 描述: 获取所有角色
     * 作者: gongwang
     * 日期: 2018/1/26
     * 时间: 下午4:29
     **/
    List<SysRole> getAllRoles();
    /**
     * 类名:
     * 参数: 
     * 描述: 分页获取所有角色
     * 作者: gongwang
     * 日期: 2018/2/8
     * 时间: 下午1:09
     **/
    PageInfo<SysRole> getAllRolesPaged(SysRole sysRole);
    /**
     * 类名:
     * 参数: 
     * 描述: 添加角色
     * 作者: gongwang
     * 日期: 2018/2/12
     * 时间: 上午9:14
     **/
    int addRole(SysRole sysRole);

    /**
    　* @描述:     通过id删除角色
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/2 14:50
      */
    int delRoleById(Long id);

    /**
    　* @描述:     启用角色
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/2 15:16
      */
    int enableRoleById(Long id);
    /**
    　* @描述:     通过id获取角色
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/5 18:51
      */
    SysRole getRoleById(Long id);
    /**
    　* @描述:     修改角色属性
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/5 19:26
      */
    int updateRole(SysRole sysRole);
}

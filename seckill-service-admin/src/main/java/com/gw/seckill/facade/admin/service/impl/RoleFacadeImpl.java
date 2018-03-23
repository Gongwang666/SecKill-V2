package com.gw.seckill.facade.admin.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.gw.seckill.core.admin.biz.RoleBiz;
import com.gw.seckill.facade.admin.entity.SysRole;
import com.gw.seckill.facade.admin.service.RoleFacade;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
　* @描述:     角色管理dubbo实现
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/1/12 15:07
  */
@Service(version = "1.0.0")
public class RoleFacadeImpl implements RoleFacade {
    @Autowired
    private RoleBiz roleBiz;


    @Override
    public Set<Long> findRoleResourceIDs(Long[] roleIds) {
        return roleBiz.findRoleResourceIDs(roleIds);
    }

    @Override
    public List<SysRole> getAllRoles() {
        return roleBiz.getAllRoles();
    }

    @Override
    public PageInfo<SysRole> getAllRolesPaged(SysRole sysRole) {
        return roleBiz.getAllRolesPaged(sysRole);
    }

    @Override
    public int addRole(SysRole sysRole) {
        return roleBiz.addRole(sysRole);
    }

    @Override
    public int delRoleById(Long id) {
        return roleBiz.delRoleById(id);
    }

    @Override
    public int enableRoleById(Long id) {
        return roleBiz.enableRoleById(id);
    }

    @Override
    public SysRole getRoleById(Long id) {
        return roleBiz.getRoleById(id);
    }

    @Override
    public int updateRole(SysRole sysRole) {
        return roleBiz.updateRole(sysRole);
    }
}

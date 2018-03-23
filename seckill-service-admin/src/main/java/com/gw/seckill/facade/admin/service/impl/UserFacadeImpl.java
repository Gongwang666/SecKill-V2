package com.gw.seckill.facade.admin.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.gw.seckill.core.admin.biz.UserBiz;
import com.gw.seckill.facade.admin.entity.SysResource;
import com.gw.seckill.facade.admin.entity.SysUser;
import com.gw.seckill.facade.admin.service.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
/**
　* @描述:     用户管理dubbo实现
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/1/12 15:06
  */
@Service(version = "1.0.0")
public class UserFacadeImpl implements UserFacade {
    @Autowired
    private UserBiz userBiz;
    @Override
    public Set<String> findPermissions(String username) {
        return userBiz.findPermissions(username);
    }

    @Override
    public SysUser findByAccount(String userName) {
        return userBiz.findByAccount(userName);
    }

    @Override
    public Set<String> findPermissionUrl(String userName) {
        return userBiz.findPermissionUrl(userName);
    }

    @Override
    public int addSysUser(SysUser sysUser) {
        return userBiz.addSysUserDefault(sysUser);
    }

    @Override
    public List<SysUser> getAllUsers() {
        return userBiz.getAllUsers();
    }

    @Override
    public int deBlockingUser(Long userID) {
        return userBiz.deBlockingUser(userID);
    }

    @Override
    public int blockingUser(Long userID) {
        return userBiz.blockingUser(userID);
    }

    @Override
    public PageInfo<SysUser> getAllUsersPaged(SysUser sysUser) {
        return userBiz.getAllUsersPaged(sysUser);
    }
}

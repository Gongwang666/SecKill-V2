package com.gw.seckill.facade.admin.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.gw.seckill.core.admin.biz.ResourceBiz;
import com.gw.seckill.facade.admin.entity.SysResource;
import com.gw.seckill.facade.admin.service.ResourceFacade;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 　* @描述:     角色管理dubbo实现
 　* @异常:
 　* @作者:     gongwang
 　* @创建时间: 2018/1/12 15:07
 */
@Service(version = "1.0.0")
public class ResourceFacadeImpl implements ResourceFacade{
    @Autowired
    private ResourceBiz resourceBiz;

    @Override
    public void deleteSysResource(Long resID) {
        resourceBiz.deleteSysResource(resID);
    }

    @Override
    public List<SysResource> getAllResources() {
        return resourceBiz.getAllResources();
    }

    @Override
    public void addSysRes(SysResource sysResource) {
        resourceBiz.addSysRes(sysResource);
    }

    @Override
    public SysResource getResourcesByID(Long resID) {
        return resourceBiz.getResourceByID(resID);
    }

    @Override
    public int updateResources(SysResource sysResource) {
        return resourceBiz.updateResources(sysResource);
    }

    @Override
    public int enableRes(Long resId) {
        return resourceBiz.enableRes(resId);
    }

    @Override
    public PageInfo<SysResource> getAllResourcesPaged(SysResource sysResource) {
        return resourceBiz.getAllResourcesPaged(sysResource);
    }

    @Override
    public Integer getResTotalCount() {
        return resourceBiz.getResTotalCount();
    }
}

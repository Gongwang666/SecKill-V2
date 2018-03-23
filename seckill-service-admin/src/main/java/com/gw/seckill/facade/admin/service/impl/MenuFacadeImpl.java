package com.gw.seckill.facade.admin.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gw.seckill.core.admin.biz.MenuBiz;
import com.gw.seckill.facade.admin.entity.SysResource;
import com.gw.seckill.facade.admin.service.MenuFacade;
import com.gw.seckill.facade.admin.vo.MenuTreeVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
　* @描述:     菜单管理dubbo服务实现类
　* @异常:
　* @作者:     gongwang
　* @创建时间: 2018/1/9 10:42
  */
@Service(version = "1.0.0")
public class MenuFacadeImpl implements MenuFacade {
    @Autowired
    private MenuBiz menuBiz;
    @Override
    public List<MenuTreeVO> getMenuTree() {
        return menuBiz.getMenuTree();
    }

}

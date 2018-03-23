package com.gw.seckill.facade.admin.service;

import com.gw.seckill.facade.admin.entity.SysResource;
import com.gw.seckill.facade.admin.vo.MenuTreeVO;

import java.util.List;

/**
　* @描述:     菜单管理接口
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/1/9 10:38
  */
public interface MenuFacade {
    /**
    　* @描述:     获得树形菜单列表
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/9 10:40
      */
    List<MenuTreeVO> getMenuTree();


}

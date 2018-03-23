package com.gw.seckill.core.admin.biz;

import com.gw.seckill.core.admin.dao.SysResourceMapper;
import com.gw.seckill.core.admin.util.MenuUtil;
import com.gw.seckill.facade.admin.entity.SysResource;
import com.gw.seckill.facade.admin.vo.MenuTreeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
　* @描述:     菜单管理服务
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/1/9 10:42
  */
@Service("menuBiz")
public class MenuBiz {
    @Autowired
    private SysResourceMapper sysResourceDAO;

    public List<MenuTreeVO> getMenuTree() {
        List<SysResource> resList = sysResourceDAO.selectAll();
        List<MenuTreeVO> menuTreeVOList = new ArrayList<MenuTreeVO>();
        for(SysResource sysResource : resList){
            if(sysResource.getAvailable() == (byte)1){
                MenuTreeVO menuTreeVO = new MenuTreeVO(sysResource.getResName(),
                        sysResource.getResType(),
                        sysResource.getResUrl());
                menuTreeVO.setId(sysResource.getId());
                menuTreeVO.setParentId(sysResource.getParentId());
                menuTreeVOList.add(menuTreeVO);
            }
        }
        MenuUtil menuUtil = new MenuUtil();
        return menuUtil.getChildTreeObjects(menuTreeVOList,(long)1);
    }

}

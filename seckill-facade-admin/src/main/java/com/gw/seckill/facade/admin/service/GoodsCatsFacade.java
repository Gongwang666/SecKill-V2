package com.gw.seckill.facade.admin.service;

import com.github.pagehelper.PageInfo;
import com.gw.seckill.facade.admin.entity.GoodsCats;

import java.util.List;


/**
　* @描述:     商品分类管理接口
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2017/12/29 10:54
  */
public interface GoodsCatsFacade {
    /**
    　* @描述:     获取所有的商品分类信息
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/5 20:43
      */
    List<GoodsCats> getAllGoodCats();

    /**
    　* @描述:     获取商品分类树形结构
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/5 20:49
      */
    List<GoodsCats> getGoodsCatsTree();
    /**
    　* @描述:     分页查询分类信息
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/6 10:20
      */
    PageInfo<GoodsCats> getAllCatsPaged(GoodsCats goodsCats);
    /**
    　* @描述:     添加商品分类
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/6 10:54
      */
    int addCats(GoodsCats goodsCats);
    
    /**
    　* @描述:     删除分类
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/6 14:30
      */
    int delCat(Long id);
    /**
    　* @描述:     通过id获取商品分类
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/6 14:33
      */
    GoodsCats getCatsById(Long id);
    /**
    　* @描述:     修改分类信息
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/6 15:18
      */
    int editCat(GoodsCats goodsCats);
    /**
    　* @描述:     启用分类
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/6 15:50
      */
    int enableCats(Long id);
    
    /**
    　* @描述:     获取指定节点下的所有子节点
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/7 14:53
      */
    List<GoodsCats> getChildList(GoodsCats goodsCats);

    String getCatIdPath(Long id);

    /**
    　* @描述:     通过分类名称获取分类信息
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/4/10 16:22
      */
    GoodsCats getCatsByName(String name);
}

package com.gw.seckill.facade.admin.service;
import com.github.pagehelper.PageInfo;
import com.gw.seckill.facade.admin.entity.GoodsImg; /**
　* @描述:     商品图片服务接口
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/3/15 23:32
  */
public interface GoodsImgFacade {
    /**
    　* @描述:     添加图片
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/15 23:42
      */
    int addImg(GoodsImg goodsImg);
    /**
    　* @描述:     通过商品id，获取已经分页的所有商品图片信息
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/20 13:46
      */
    PageInfo<GoodsImg> getAllImgPaged(GoodsImg goodsImg);
    /**
    　* @描述:     删除图片
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/20 15:30
      */
    int delImg(Long[] ids);
    /**
    　* @描述:     通过id获取图片信息
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/20 15:40
      */
    GoodsImg getImgById(Long id);
}

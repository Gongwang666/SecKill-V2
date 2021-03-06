package com.gw.seckill.facade.admin.service;
import com.github.pagehelper.PageInfo;
import com.gw.seckill.facade.admin.entity.Goods;
/**
　* @描述:     商品信息管理接口
　* @参数描述: 
　* @返回值:
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/3/7 10:24
  */
public interface GoodsFacade {
    /**
    　* @描述:     获取分页后的所有商品信息
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/7 10:47
      */
    PageInfo<Goods> getAllGoodsPaged(Goods goods);

    PageInfo<Goods> getAllGoodsPagedWithImgs(Goods goods);
    /**
    　* @描述:     添加商品
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/21 11:16
      */
    int addGoods(Goods goods);
    /**
     * 类名:
     * 参数: 
     * 描述: 设置商品首要显示图片
     * 作者: gongwang
     * 日期: 2018/3/26
     * 时间: 下午10:02
     **/
    int setGoodsImgPath(Long id);
    /**
     * 类名:
     * 参数: 
     * 描述: 删除商品
     * 作者: gongwang
     * 日期: 2018/4/7
     * 时间: 下午3:29
     **/
    int delGoods(Long id);
    /**
     * 类名:
     * 参数: 
     * 描述: 启用商品
     * 作者: gongwang
     * 日期: 2018/4/7
     * 时间: 下午3:36
     **/
    int enableGoods(Long id);
    /**
     * 类名: 
     * 参数: 
     * 描述: 商品上架
     * 作者: gongwang
     * 日期: 2018/4/7
     * 时间: 下午4:20
     **/
    int groundingGoods(Long id);
    /**
     * 类名:
     * 参数: 
     * 描述: 下架商品
     * 作者: gongwang
     * 日期: 2018/4/7
     * 时间: 下午4:26
     **/
    int pullOff(Long id);
}

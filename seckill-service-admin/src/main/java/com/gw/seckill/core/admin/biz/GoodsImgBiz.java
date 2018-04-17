package com.gw.seckill.core.admin.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gw.seckill.core.admin.dao.GoodsImgMapper;
import com.gw.seckill.facade.admin.entity.GoodsImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("goodsImgBiz")
public class GoodsImgBiz {
    @Autowired
    private GoodsImgMapper goodsImgDAO;

    /**
    　* @描述:     添加图片
    　* @参数描述: 
    　* @返回值:   
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/15 23:44
      */
    public int addImg(GoodsImg goodsImg) {
        goodsImg.setType(1);
        return goodsImgDAO.insert(goodsImg);
    }
    /**
    　* @描述:     获取所有图片信息
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/20 13:47
      */
    public PageInfo<GoodsImg> getAllImgPaged(GoodsImg goodsImg) {
        if(goodsImg.getPage()!=null&&goodsImg.getRows()!=null){
            PageHelper.startPage(goodsImg.getPage(),goodsImg.getRows());
        }
        return new PageInfo<GoodsImg>(goodsImgDAO.select(goodsImg));
    }
    /**
    　* @描述:     删除图片
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/20 15:31
      */
    public int delImg(Long[] ids) {
        int rows = 0;
        for(int i = 0 ; i<ids.length ; i++){
            int row = goodsImgDAO.deleteByPrimaryKey(ids[i]);
            if(row == 1){
                rows++;
            }
        }
        return rows;
    }
    /**
    　* @描述:     通过id获取图片信息
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/20 15:41
      */
    public GoodsImg getImgById(Long id) {
        return goodsImgDAO.selectByPrimaryKey(id);
    }
}

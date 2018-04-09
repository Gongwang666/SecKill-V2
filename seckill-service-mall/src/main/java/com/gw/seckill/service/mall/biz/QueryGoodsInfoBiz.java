package com.gw.seckill.service.mall.biz;

import com.gw.seckill.core.admin.dao.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("queryGoodsInfoBiz")
public class QueryGoodsInfoBiz {
    @Autowired
    private GoodsMapper goodsDAO;
}

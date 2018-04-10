package com.gw.seckill.service.mall.biz;

import com.gw.seckill.MallApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MallApplication.class)
public class QueryGoodsInfoBizTest {
    @Autowired
    private QueryGoodsInfoBiz queryGoodsInfoBiz;
    @Test
    public void getHomePageGoodsList() {
        queryGoodsInfoBiz.getHomePageGoodsList();
    }
}

package com.gw.seckill.service.mall.biz;

import com.gw.seckill.MallApplication;
import com.gw.seckill.facade.mall.dto.DTOSpecInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MallApplication.class)
public class QueryGoodsInfoBizTest {
    @Autowired
    private QueryGoodsInfoBiz queryGoodsInfoBiz;
    @Test
    public void getHomePageGoodsList() {
        queryGoodsInfoBiz.getHomePageGoodsList();
    }

    @Test
    public void getSpecInfoByGoodsId(){
        DTOSpecInfo info = queryGoodsInfoBiz.getSpecInfoByGoodsId((long)6);
        System.out.print(1);
    }
}

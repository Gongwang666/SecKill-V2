package com.gw.seckill.core.admin.biz;

import com.gw.seckill.facade.admin.entity.GoodsImg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsImgBizTest {
    @Autowired
    private GoodsImgBiz goodsImgBiz;
    @Test
    public void getImgById() {
        GoodsImg goodsImg = goodsImgBiz.getImgById((long)5);
        System.out.print(0);
    }
}

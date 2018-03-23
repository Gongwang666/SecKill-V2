package com.gw.seckill.core.admin.biz;

import com.github.pagehelper.PageInfo;
import com.gw.seckill.facade.admin.entity.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsBizTest {
    @Autowired
    private GoodsBiz goodsBiz;
    @Test
    public void getAllGoodsPagedWithImgs() {
        Goods goods = new Goods();
        goods.setPage(1);
        goods.setRows(10);
        PageInfo<Goods> pageInfo = goodsBiz.getAllGoodsPagedWithImgs(goods);
        System.out.print(0);
    }
}

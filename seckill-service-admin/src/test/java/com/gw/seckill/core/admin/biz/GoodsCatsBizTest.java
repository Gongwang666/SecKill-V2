package com.gw.seckill.core.admin.biz;

import com.gw.seckill.facade.admin.entity.GoodsCats;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsCatsBizTest {
    @Autowired
    private GoodsCatsBiz goodsCatsBiz;
    @Test
    public void getAllGoodCats() {
    }

    @Test
    public void getGoodsCatsTree() {
        List<GoodsCats> list = goodsCatsBiz.getGoodsCatsTree();
        System.out.print(0);
    }

    @Test
    public void getChildList(){
        GoodsCats goodsCats = new GoodsCats();
        goodsCats.setId((long)3);
        goodsCats.setParentId((long)1);
        List<GoodsCats> list = goodsCatsBiz.getChildList(goodsCats);
        System.out.print(0);
    }
    @Test
    public  void getCatIdPath(){
        String path = goodsCatsBiz.getCatIdPath((long)32);
        System.out.print(0);
    }
}

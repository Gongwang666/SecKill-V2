package com.gw.seckill.core.admin.biz;

import com.github.pagehelper.PageInfo;
import com.gw.seckill.facade.admin.entity.SysResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceBizTest {
    @Autowired
    private ResourceBiz resourceBiz;
    @Test
    public void getAllResourcesPaged() {
        SysResource sysResource = new SysResource();
        PageInfo<SysResource> list = resourceBiz.getAllResourcesPaged(sysResource);
        System.out.print(0);
    }
    @Test
    public void getResTotalCount() {
        Integer count =  resourceBiz.getResTotalCount();
        System.out.print(0);
    }
}

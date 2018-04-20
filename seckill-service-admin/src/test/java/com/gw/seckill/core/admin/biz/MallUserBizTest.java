package com.gw.seckill.core.admin.biz;

import com.gw.seckill.facade.admin.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MallUserBizTest {
    @Autowired
    private MallUserBiz mallUserBiz;
    @Test
    public void addMallUser() {
        User user = new User();
        user.setUserName("gw");
        user.setPassWord("123");
        mallUserBiz.addMallUser(user);
    }
}

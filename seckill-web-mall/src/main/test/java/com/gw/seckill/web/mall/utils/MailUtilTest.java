package com.gw.seckill.web.mall.utils;


import com.gw.seckill.web.mall.MallWebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MallWebApplication.class)
public class MailUtilTest {
    @Test
    public void sendSimpleEmail(){
        MailUtil mail = new MailUtil();
        mail.sendSimpleEmail("www.253285277@qq.com","aa","bb");
    }
}

package com.gw.seckill.web.mall.utils;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailUtil {
    private final Logger logger = Logger.getLogger(MailUtil.class);
    @Autowired
    private JavaMailSender mailSender;//spring 提供的邮件发送类
    //@Value("${mail.mail.username}")
    private String from ="www.1543971447@qq.com" ;

    public void sendSimpleEmail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();//创建简单邮件消息
        message.setFrom(from);//设置发送人
        message.setTo(to);//设置收件人

        /* String[] adds = {"xxx@qq.com","yyy@qq.com"}; //同时发送给多人
        message.setTo(adds);*/

        message.setSubject(subject);//设置主题
        message.setText(content);//设置内容
        try {
            mailSender.send(message);//执行发送邮件
        } catch (Exception e) {
            logger.error("邮件发送异常:"+e.toString());
        }
    }
}

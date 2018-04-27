package com.gw.seckill.web.mall.controller;

import com.gw.seckill.common.web.exception.pojo.Result;
import com.gw.seckill.facade.admin.entity.User;
import com.gw.seckill.web.mall.utils.MailUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.util.Date;

@RestController
public class UserController {
    private final Logger logger = Logger.getLogger(UserController.class);
    @RequestMapping("/register")
    public ModelAndView register(){
        ModelAndView mo = new ModelAndView();
        mo.setViewName("/pages/register");
        return mo;
    }
    @RequestMapping("/loginPage")
    public ModelAndView loginPage(){
        ModelAndView mo = new ModelAndView();
        mo.setViewName("/pages/user_login");
        return mo;
    }

    @RequestMapping("/login")
    public Result login(User user){
        Result result = new Result();
        if(user == null){
            throw new RuntimeException("用户为空!");
        }
        String account = user.getUserName();
        String password = user.getPassWord();
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        Subject subject = SecurityUtils.getSubject();
        //User us =(User) subject.getSession().getAttribute("user");
        try {
            subject.login(token);
        }catch (LockedAccountException e){
            e.printStackTrace();
            result.setStatus(-1);
            result.setMsg("账号被锁定!");
            return result;
        }catch (ExcessiveAttemptsException e){
            //尝试登陆次数超过5次，账号锁定10分钟
            e.printStackTrace();
            result.setStatus(-1);
            result.setMsg("对不起，超过登录次数，10分钟内，帐号将被锁定!");
            return result;
        }catch (AuthenticationException e) {
            e.printStackTrace();
            result.setStatus(-1);
            result.setMsg("用户名或密码错误!");
            return result;
        }
        result.setStatus(0);
        result.setMsg("登录成功!");
        return result;
    }
    @RequestMapping("/getSessionUserInfo")
    public User getSessionUserInfo(){
        return (User) SecurityUtils.getSubject().getSession().getAttribute("user");
    }
    @RequestMapping("/logout")
    public void logout(){
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getSession().getAttribute("user");
        subject.logout();
        logger.info("用户:"+user.getUserName()+"在"+new Date()+"退出的登录");
    }

    @RequestMapping("/doRegister")
    public void doRegister(){

    }
}

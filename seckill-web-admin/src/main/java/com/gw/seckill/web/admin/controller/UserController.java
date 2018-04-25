package com.gw.seckill.web.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gw.seckill.common.web.exception.enums.ExceptionEnum;
import com.gw.seckill.common.web.exception.handler.WebGlobalExceptionHandler;
import com.gw.seckill.facade.admin.entity.SysUser;
import com.gw.seckill.facade.admin.service.UserFacade;
import com.gw.seckill.web.admin.cache.SpringCacheManagerWrapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

/**
　* @描述:     用户登录，登出，验证Controller
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/1/5 16:13
  */
@Controller
public class UserController {

    @Reference(version = "1.0.0")
    private UserFacade userFacade;
    //统一异常处理
    @Autowired
    private WebGlobalExceptionHandler webGlobalExceptionHandler;
    @Autowired
    private SpringCacheManagerWrapper shiroCacheManager;

    @RequestMapping("/user/login")
    public String toLogin(){
        return "login";
    }
    /**
    　* @描述:     登录操作
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/11 18:34
      */
    @RequestMapping("/user/login.do")
    public ModelAndView login(SysUser sysUser){
        ModelAndView mv = new ModelAndView();
        if(sysUser == null){
            webGlobalExceptionHandler.exceptionGet(new Exception(ExceptionEnum.USER_LOGIN_ERROR.getMsg()));
        }
        String account = sysUser.getUserName();
        String password = sysUser.getPassWord();
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        }catch (LockedAccountException e){
            e.printStackTrace();
            mv.setViewName("/user/login");
            mv.addObject("message","对不起，您的账号被锁了，请找相关管理员解决！");
            return mv;
        }catch (ExcessiveAttemptsException e){
            //尝试登陆次数超过5次，账号锁定10分钟
            e.printStackTrace();
            mv.setViewName("/user/login");
            mv.addObject("message","对不起，超过登录次数，10分钟内，帐号将被锁定！");
            return mv;
        }catch (AuthenticationException e) {
            e.printStackTrace();
            webGlobalExceptionHandler.exceptionGet(new Exception(ExceptionEnum.USER_NOT_FIND.getMsg()));
            mv.setViewName("/user/login");
            mv.addObject("message","用户名或密码错误!");
            return mv;
        }
        mv.setViewName("redirect:/index.do");
        return mv;
    }

    @RequestMapping("/user/logout.do")
    public String userLogOut(){
        Cache<String, Set<String>> authorizationCache = shiroCacheManager.getCache("authorizationCache");
        Subject subject = SecurityUtils.getSubject();
        String userName = subject.getPrincipal().toString();
        //用户登出时清除权限缓存
        authorizationCache.remove(userName);
        subject.logout();
        return "redirect:/user/login";
    }

    @RequestMapping("/user/kickout")
    public ModelAndView userKickOut(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/404");
        mv.addObject("message","对不起，该账户在其他地方登录，请重新登录!");
        mv.addObject("url","/user/login");
        return mv;
    }

}

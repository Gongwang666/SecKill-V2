package com.gw.seckill.web.mall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {
    @RequestMapping("/user/register")
    public ModelAndView register(){
        ModelAndView mo = new ModelAndView();
        mo.setViewName("/pages/register");
        return mo;
    }
    @RequestMapping("/user/login")
    public ModelAndView homePage(){
        ModelAndView mo = new ModelAndView();
        mo.setViewName("/pages/login");
        return mo;
    }
}

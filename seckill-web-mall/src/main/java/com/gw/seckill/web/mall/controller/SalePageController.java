package com.gw.seckill.web.mall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SalePageController {
    @RequestMapping("/home")
    public ModelAndView homePage(){
        ModelAndView mo = new ModelAndView();
        mo.setViewName("/pages/home");
        return mo;
    }
}

package com.gw.seckill.web.mall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class OrderController {
    @RequestMapping("/order")
    public ModelAndView orderPage(){
        ModelAndView mo = new ModelAndView();
        mo.setViewName("/pages/order");
        return mo;
    }
}

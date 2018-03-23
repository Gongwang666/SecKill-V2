package com.gw.seckill.web.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gw.seckill.common.web.exception.enums.ExceptionEnum;
import com.gw.seckill.common.web.exception.handler.WebGlobalExceptionHandler;
import com.gw.seckill.common.web.exception.pojo.Result;
import com.gw.seckill.common.web.exception.utils.ResultUtil;
import com.gw.seckill.facade.admin.entity.GoodsCats;
import com.gw.seckill.facade.admin.service.GoodsCatsFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {
    //dubbo注解
    @Reference(version = "1.0.0")
    private GoodsCatsFacade goodsCatsFacade;
    //统一异常处理
    @Autowired
    private WebGlobalExceptionHandler webGlobalExceptionHandler;


    @RequestMapping("/index.do")
    public String toIndex(){
        return "index";
    }


    @RequestMapping("/errorMessage")
    public String error(){

        return "404";
    }


}

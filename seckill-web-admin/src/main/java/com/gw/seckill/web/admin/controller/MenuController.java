package com.gw.seckill.web.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gw.seckill.facade.admin.service.MenuFacade;
import com.gw.seckill.facade.admin.vo.MenuTreeVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MenuController {
    @Reference(version = "1.0.0")
    private MenuFacade menuFacade;

    @ResponseBody
    @RequestMapping("/menu")
    public List<MenuTreeVO> menu(){
        return menuFacade.getMenuTree();
    }
}

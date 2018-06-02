package com.gw.seckill.web.mall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gw.seckill.common.web.exception.pojo.Result;
import com.gw.seckill.facade.admin.entity.User;
import com.gw.seckill.facade.mall.dto.DTOOrder;
import com.gw.seckill.facade.mall.dto.DTOOrderInfo;
import com.gw.seckill.facade.mall.service.OrderFacade;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class OrderController {
    @Reference(version = "1.0.0")
    private OrderFacade orderFacade;
    @RequestMapping("/order")
    public ModelAndView orderPage(){
        ModelAndView mo = new ModelAndView();
        mo.setViewName("/pages/order");
        return mo;
    }
    @RequestMapping("/toPayPage")
    public ModelAndView toOrderPage(){
        ModelAndView mo = new ModelAndView();
        mo.setViewName("/pages/pay");
        return mo;
    }
    @RequestMapping("/addToOrder")
    public Result addToOrder(DTOOrderInfo orderInfo){
        Result result = new Result();
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        Integer orderId = orderFacade.addToOrder(orderInfo,user.getId().intValue());
        result.setMsg("添加订单");
        result.setStatus(1);
        result.setData(orderId);
        return result;
    }

    @RequestMapping("/getUnPayOrders")
    public List<DTOOrder> getUnPayOrders(){
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        List<DTOOrder> orderInfo = orderFacade.getUnPayOrders(user.getId());
        return orderInfo;
    }
}

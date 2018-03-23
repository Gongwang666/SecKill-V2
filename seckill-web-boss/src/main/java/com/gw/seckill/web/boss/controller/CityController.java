package com.gw.seckill.web.boss.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gw.seckill.facade.mall.entity.City;
import com.gw.seckill.facade.mall.service.CityFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    @Reference(version = "1.0.0")
    private CityFacade cityFacade;

    @RequestMapping("/city")
    public City getCity(){
        return cityFacade.findCityByName("温岭市");
    }
}

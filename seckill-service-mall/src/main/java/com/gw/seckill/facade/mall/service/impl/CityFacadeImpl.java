package com.gw.seckill.facade.mall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gw.seckill.facade.mall.entity.City;
import com.gw.seckill.facade.mall.service.CityFacade;
import com.gw.seckill.service.mall.biz.CityBiz;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 城市业务 Dubbo 服务层实现层
 *
 * Created by bysocket on 28/02/2017.
 */
// 注册为 Dubbo 服务
@Service(version = "1.0.0")
public class CityFacadeImpl implements CityFacade {

    @Autowired
    private CityBiz cityBiz;
    @Override
    public City findCityByName(String cityName) {
        return cityBiz.findCityByName(cityName);
    }
}

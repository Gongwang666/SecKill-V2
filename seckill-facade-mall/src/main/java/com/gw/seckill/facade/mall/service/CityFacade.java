package com.gw.seckill.facade.mall.service;

import com.gw.seckill.facade.mall.entity.City;


public interface CityFacade {

    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    City findCityByName(String cityName);
}

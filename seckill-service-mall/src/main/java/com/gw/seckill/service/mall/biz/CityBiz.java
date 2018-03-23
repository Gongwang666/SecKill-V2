package com.gw.seckill.service.mall.biz;

import com.gw.seckill.facade.mall.entity.City;
import com.gw.seckill.service.mall.dao.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cityBiz")
public class CityBiz {
    @Autowired
    private CityDao cityDao;

    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }
}

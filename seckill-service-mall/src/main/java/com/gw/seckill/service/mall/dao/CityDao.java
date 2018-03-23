package com.gw.seckill.service.mall.dao;

import com.gw.seckill.facade.mall.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
@Repository("cityDao")
@Mapper
public interface CityDao {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    City findByName(@Param("cityName") String cityName);
}

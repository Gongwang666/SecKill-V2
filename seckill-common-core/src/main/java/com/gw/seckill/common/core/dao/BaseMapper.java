package com.gw.seckill.common.core.dao;

import org.springframework.data.repository.NoRepositoryBean;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@NoRepositoryBean
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
    //TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错

}

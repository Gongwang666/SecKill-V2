package com.gw.seckill.core.admin.config;

import com.gw.seckill.common.core.dao.BaseMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

@Configuration
public class MyMapperScannerConfigurer {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setMarkerInterface(BaseMapper.class);
        msc.setBasePackage("com.gw.seckill.core.admin.dao");
        return msc;
    }
}

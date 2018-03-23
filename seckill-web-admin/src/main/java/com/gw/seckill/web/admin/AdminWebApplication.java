package com.gw.seckill.web.admin;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
　* @描述:     SpingBoot启动类
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2017/12/28 17:44
  */
@SpringBootApplication
@PropertySource(value = {"classpath:service.properties"})
@Import(FdfsClientConfig.class)
@ComponentScan(basePackages = {"com.gw.seckill.common.web","com.gw.seckill.web.admin.config"})
public class AdminWebApplication {
    public static void main(String [] args){
        SpringApplication.run(AdminWebApplication.class,args);
    }
}

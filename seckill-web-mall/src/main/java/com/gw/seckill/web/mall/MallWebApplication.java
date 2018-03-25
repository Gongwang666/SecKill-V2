package com.gw.seckill.web.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:service.properties"})
public class MallWebApplication {
    public static void main(String [] args){
        SpringApplication.run(MallWebApplication.class,args);
    }
}

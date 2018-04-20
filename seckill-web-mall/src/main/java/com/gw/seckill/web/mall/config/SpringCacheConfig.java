package com.gw.seckill.web.mall.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching//<!-- 启用缓存注解 --> <cache:annotation-driven cache-manager="cacheManager" />
public class SpringCacheConfig {
    @Bean
    public EhCacheCacheManager springCacheManager(){
        EhCacheCacheManager cacheManager = new EhCacheCacheManager();
        cacheManager.setCacheManager(cacheManager().getObject());
        return cacheManager;
    }

    @Bean
    public EhCacheManagerFactoryBean cacheManager() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        return ehCacheManagerFactoryBean;
    }
}

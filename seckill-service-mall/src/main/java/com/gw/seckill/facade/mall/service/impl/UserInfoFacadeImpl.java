package com.gw.seckill.facade.mall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gw.seckill.facade.admin.entity.User;
import com.gw.seckill.facade.mall.service.UserInfoFacade;
import com.gw.seckill.service.mall.biz.UserInfoBiz;
import org.springframework.beans.factory.annotation.Autowired;
@Service(version = "1.0.0")
public class UserInfoFacadeImpl implements UserInfoFacade {
    @Autowired
    private UserInfoBiz userInfoBiz;
    @Override
    public User queryUserByAccount(String account) throws RuntimeException{
        return userInfoBiz.queryUserByAccount(account);
    }
}

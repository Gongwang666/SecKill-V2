package com.gw.seckill.facade.admin.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gw.seckill.core.admin.biz.MallUserBiz;
import com.gw.seckill.facade.admin.entity.User;
import com.gw.seckill.facade.admin.service.MallUserFacade;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0")
public class MallUserFacadeImpl implements MallUserFacade{
    @Autowired
    private MallUserBiz mallUserBiz;
    @Override
    public int addMallUser(User user) {
        return mallUserBiz.addMallUser(user);
    }
}

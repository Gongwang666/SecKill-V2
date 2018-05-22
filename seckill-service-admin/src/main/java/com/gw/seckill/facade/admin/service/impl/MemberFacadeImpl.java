package com.gw.seckill.facade.admin.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gw.seckill.core.admin.biz.MallUserBiz;
import com.gw.seckill.facade.admin.entity.User;
import com.gw.seckill.facade.admin.service.MemberFacade;
import org.springframework.beans.factory.annotation.Autowired;
@Service(version = "1.0.0")
public class MemberFacadeImpl implements MemberFacade {
    @Autowired
    private MallUserBiz mallUserBiz;
    @Override
    public int register(User user) {
        return mallUserBiz.register(user);
    }

    @Override
    public void active(String code) {
        mallUserBiz.active(code);
    }
}

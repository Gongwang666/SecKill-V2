package com.gw.seckill.facade.admin.service;

import com.gw.seckill.facade.admin.entity.User;

public interface MemberFacade {
    /**
     * 类名:
     * 参数: 
     * 描述: 　会员注册
     * 作者: gongwang
     * 日期: 2018/5/22
     * 时间: 下午2:35
     **/
    int register(User user);
    /**
     * 类名:
     * 参数: 
     * 描述: 账号激活
     * 作者: gongwang
     * 日期: 2018/5/22
     * 时间: 下午2:36
     **/
    void active(String code);
}

package com.gw.seckill.facade.mall.service;

import com.gw.seckill.facade.admin.entity.User;

/**
　* @描述:     会员信息接口
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/4/20 18:28
  */
public interface UserInfoFacade {
    User queryUserByAccount(String account)throws RuntimeException;
}

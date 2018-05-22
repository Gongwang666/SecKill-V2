package com.gw.seckill.service.mall.biz;

import com.gw.seckill.core.admin.dao.UserMapper;
import com.gw.seckill.facade.admin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userInfoBiz")
public class UserInfoBiz {
    @Autowired
    private UserMapper userMapper;

    public User queryUserByAccount(String account) throws RuntimeException{
        User user = new User();
        user.setUserName(account);
        List<User> list = userMapper.select(user);
        if(list!=null&&list.size()>1){
            throw new RuntimeException("同一用户名存在多个账户!");
        }
        if(list.size()==0){
            return null;
        }
        return list.get(0);
    }
}

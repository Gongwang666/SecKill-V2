package com.gw.seckill.core.admin.biz;

import com.gw.seckill.constants.ConstantClassFunction;
import com.gw.seckill.core.admin.dao.UserMapper;
import com.gw.seckill.facade.admin.entity.User;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("mallUserBiz")
public class MallUserBiz {
    @Autowired
    private UserMapper userMapper;
    public int addMallUser(User user) {
        String username = user.getUserName();
        String password = user.getPassWord();
        if(username==null||password==null||username.isEmpty()||password.isEmpty()){
            return -1;
        }
        //以用户名为第一个盐值
        String salt1 = username;
        //以随机数为第二个盐值，要存储到数据库
        String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
        //哈希次数
        int hashIterations = ConstantClassFunction.getHASH_ITERATIONS();
        //加密算法
        String algorithmName = ConstantClassFunction.getALGORITHM_NAME();

        SimpleHash hash = new SimpleHash(algorithmName, password, salt1 + salt2, hashIterations);
        //加密后的密码串，存入数据库
        String encodedPassword = hash.toHex();

        user.setPassWord(encodedPassword);
        user.setSalt(salt2);
        //0表示未激活，1表示已激活
        user.setDataFlag(0);
        user.setUrlStr(UUID.randomUUID().toString());
        return userMapper.insert(user);
    }

    public int register(User user) {
        return addMallUser(user);
    }

    public void active(String code) {
        User user = new User();
        user.setUrlStr(code);
        User memberInfo = userMapper.selectOne(user);
        memberInfo.setDataFlag(1);
        memberInfo.setUrlStr("");
        userMapper.updateByPrimaryKeySelective(memberInfo);
    }
}

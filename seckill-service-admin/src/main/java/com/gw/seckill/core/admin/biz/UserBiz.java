package com.gw.seckill.core.admin.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gw.seckill.constants.ConstantClassFunction;
import com.gw.seckill.core.admin.dao.SysUserMapper;
import com.gw.seckill.facade.admin.entity.SysResource;
import com.gw.seckill.facade.admin.entity.SysUser;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
　* @描述:     用户管理业务
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/1/5 16:58
  */
@Service("userBiz")
public class UserBiz {
    @Autowired
    private SysUserMapper sysUserDAO;
    @Autowired
    private RoleBiz roleBiz;
    @Autowired
    private ResourceBiz resourceBiz;

    /**
    　* @描述:     通过用户名查找用户权限
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/16 18:43
      */
    public Set<String> findPermissions(String username) {
        Long[] ids = findUserRoleIDs(username);
        if(ids == null) {
            return Collections.EMPTY_SET;
        }
        Set<Long> resourceIDs = roleBiz.findRoleResourceIDs(ids);
        return resourceBiz.findPermissions(resourceIDs);
    }
    /**
    　* @描述:     通过用户名查找用户信息
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/16 18:43
      */
    public SysUser findByAccount(String userName) {
        //只返回一个结果，多个结果会抛出异常
        return sysUserDAO.selectOne(new SysUser(userName));
    }
    /**
     　* @描述:     查找用户所拥有的角色id
     　* @参数描述:
     　* @返回值:
     　* @异常:
     　* @作者:     gongwang
     　* @创建时间: 2018/1/16 18:21
     */
    public Long[] findUserRoleIDs(String userName) {
        SysUser sysUser =sysUserDAO.selectOne(new SysUser(userName));
        if(sysUser == null) {
            return null;
        }
        String[] roleIDs = sysUser.getRoleIds().split(",");
        Long[] ids =(Long[]) ConvertUtils.convert(roleIDs,Long.class);
        return  ids;
    }
    /**
    　* @描述:     通过用户名查找用户可以访问的URL集合
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/16 18:44
      */
    public Set<String> findPermissionUrl(String userName) {
        Long[] ids = findUserRoleIDs(userName);
        if(ids == null) {
            return Collections.EMPTY_SET;
        }
        Set<Long> resourceIDs = roleBiz.findRoleResourceIDs(ids);
        Set<String> sysResourceSet =resourceBiz.findResourceURLs(resourceIDs);
        return sysResourceSet;
    }
    /**
    　* @描述:    添加用户
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/17 21:45
      */
    public int addSysUser(SysUser sysUser) {
        String username = sysUser.getUserName();
        String password = sysUser.getPassWord();
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

        sysUser.setPassWord(encodedPassword);
        sysUser.setSalt(salt2);
        return sysUserDAO.insertSelective(sysUser);
    }
    /**
     * 类名:
     * 参数: 
     * 描述: 添加用户，默认密码为123456
     * 作者: gongwang
     * 日期: 2018/1/26
     * 时间: 下午5:51
     **/
    public int addSysUserDefault(SysUser sysUser){
        sysUser.setPassWord(ConstantClassFunction.getDEFAULT_PASSWORD());
        return addSysUser(sysUser);
    }

    public List<SysUser> getAllUsers() {
        return sysUserDAO.selectAll();
    }

    public int deBlockingUser(Long userID) {
        SysUser sysUser = new SysUser();
        sysUser.setId(userID);
        sysUser.setLocked((byte)0);
        return sysUserDAO.updateByPrimaryKeySelective(sysUser);
    }

    public int blockingUser(Long userID) {
        SysUser sysUser = new SysUser();
        sysUser.setId(userID);
        sysUser.setLocked((byte)1);
        return sysUserDAO.updateByPrimaryKeySelective(sysUser);
    }

    public PageInfo<SysUser> getAllUsersPaged(SysUser sysUser) {
        if (sysUser.getPage() != null && sysUser.getRows() != null) {
            PageHelper.startPage(sysUser.getPage(), sysUser.getRows());
        }
        return new PageInfo<SysUser>(sysUserDAO.selectAll());
    }
}

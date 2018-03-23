package com.gw.seckill.core.admin.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gw.seckill.core.admin.dao.SysRoleMapper;
import com.gw.seckill.core.admin.dao.SysUserMapper;
import com.gw.seckill.facade.admin.entity.SysResource;
import com.gw.seckill.facade.admin.entity.SysRole;
import com.gw.seckill.facade.admin.entity.SysUser;
import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("roleBiz")
public class RoleBiz {
    @Autowired
    private SysRoleMapper sysRoleDAO;
    @Autowired
    private ResourceBiz resourceBiz;
    @Autowired
    private SysUserMapper sysUserDAO;

    /**
    　* @描述:     通过角色id查找角色所拥有的资源id
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/16 18:31
      */
    public Set<Long> findRoleResourceIDs(Long[] roleIds){
        Set<Long> resourceIds = new HashSet<Long>();
        for (Long roleId : roleIds) {
            SysRole role = sysRoleDAO.selectByPrimaryKey(roleId);
            if (role != null) {
                String[] resIds = role.getResourceIds().split(",");
                for(String id : resIds){
                    resourceIds.add(Long.parseLong(id));
                }

            }
        }
        return resourceIds;
    }
    /**
     * 类名:
     * 参数: 
     * 描述: 获取所有角色
     * 作者: gongwang
     * 日期: 2018/1/26
     * 时间: 下午4:31
     **/
    public List<SysRole> getAllRoles() {
        return sysRoleDAO.selectAll();
    }
    /**
     * 类名:
     * 参数: 
     * 描述: 分页获取所有角色
     * 作者: gongwang
     * 日期: 2018/2/8
     * 时间: 下午1:26
     **/
    public PageInfo<SysRole> getAllRolesPaged(SysRole sysRole) {
        if (sysRole.getPage() != null && sysRole.getRows() != null) {
            PageHelper.startPage(sysRole.getPage(), sysRole.getRows());
        }
        return new PageInfo<SysRole>(sysRoleDAO.selectAll());
    }
    /**
     * 类名:
     * 参数: 
     * 描述: 添加角色
     * 作者: gongwang
     * 日期: 2018/2/12
     * 时间: 上午9:15
     **/
    public int addRole(SysRole sysRole) {
        return sysRoleDAO.insertSelective(sysRole);
    }
    /**
    　* @描述:     删除角色
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/2 14:52
      */
    public int delRoleById(Long id) {
        SysRole sysRole = new SysRole();
        sysRole.setId(id);
        sysRole.setAvailable((byte)0);
        return sysRoleDAO.updateByPrimaryKeySelective(sysRole);
    }

    /**
    　* @描述:     启用角色
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/2 15:16
      */
    public int enableRoleById(Long id) {
        SysRole sysRole = new SysRole();
        sysRole.setId(id);
        sysRole.setAvailable((byte)1);
        return sysRoleDAO.updateByPrimaryKeySelective(sysRole);
    }
    /**
    　* @描述:    通过id获取角色
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/5 18:52
      */
    public SysRole getRoleById(Long id) {
        return sysRoleDAO.selectByPrimaryKey(id);
    }
    /**
    　* @描述:     更新角色属性
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/5 19:27
      */
    public int updateRole(SysRole sysRole) {
        return sysRoleDAO.updateByPrimaryKeySelective(sysRole);
    }
}

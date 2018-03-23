package com.gw.seckill.core.admin.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gw.seckill.core.admin.dao.SysResourceMapper;
import com.gw.seckill.facade.admin.entity.SysResource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("resourceBiz")
public class ResourceBiz {
    @Autowired
    private SysResourceMapper sysResourceDAO;

    public Set<String> findPermissions(Set<Long> resourceIds) {
        Set<String> permissions = new HashSet<String>();
        for(Long resourceId : resourceIds) {
            SysResource resource = sysResourceDAO.selectByPrimaryKey(resourceId);
            if(resource != null && !StringUtils.isEmpty(resource.getPermission())) {
                permissions.add(resource.getPermission());
            }
        }
        return permissions;
    }
    /**
    　* @描述:     获取资源
    　* @参数描述: 资源ID集合
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/16 18:55
      */
    public Set<String> findResourceURLs(Set<Long> resourceIDs) {
        Set<SysResource> resourceSet = new HashSet<SysResource>();
        Set<String> urlSet = new HashSet<String>();
        for (Long id : resourceIDs){
            //父节点
            SysResource sysResParent = sysResourceDAO.selectByPrimaryKey(id);
            if(sysResParent != null && !StringUtils.isEmpty(sysResParent.getResUrl())) {
                resourceSet.add(sysResParent);
            }
            List<SysResource> sysList = sysResourceDAO.select(new SysResource(id));
            if(sysList!=null){
                //子节点
                resourceSet.addAll(sysList);
            }
        }
        for(SysResource sysRes : resourceSet){
            urlSet.add(sysRes.getResUrl());
        }
        return urlSet;
    }
    /**
     　* @描述:     删除资源业务逻辑
     　* @参数描述:
     　* @返回值:
     　* @异常:
     　* @作者:     gongwang
     　* @创建时间: 2018/1/10 22:11
     */
    public void deleteSysResource(Long resID) {
        SysResource sysResource = new SysResource();
        sysResource.setId(resID);
        sysResource.setAvailable((byte)0);
        sysResourceDAO.updateByPrimaryKeySelective(sysResource);
    }

    /**
    　* @描述:     获取所有资源
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/17 16:00
      */
    public List<SysResource> getAllResources() {
        return sysResourceDAO.selectAll();
    }
    /**
    　* @描述:     分页查询所有资源
    　* @参数描述:
    　* @返回值:
    　* @异常:
    　* @作者:     gongwang
    　* @创建时间: 2018/2/5 16:37
      */
    public PageInfo<SysResource> getAllResourcesPaged(SysResource sysResource){
        if (sysResource.getPage() != null && sysResource.getRows() != null) {
            PageHelper.startPage(sysResource.getPage(), sysResource.getRows());
        }
        return new PageInfo<SysResource>(sysResourceDAO.selectAll());
    }
    /**
    　* @描述:     添加资源
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/17 16:00
      */
    public void addSysRes(SysResource sysResource) {
        sysResourceDAO.insertSelective(sysResource);
    }
    /**
     * 类名:
     * 参数: 
     * 描述: 通过资源id获取资源
     * 作者: gongwang
     * 日期: 2018/1/24
     * 时间: 下午2:48
     **/
    public SysResource getResourceByID(Long resID) {
        return sysResourceDAO.selectByPrimaryKey(resID);
    }
    /**
     * 类名:
     * 参数: 
     * 描述: 更新资源信息
     * 作者: gongwang
     * 日期: 2018/1/24
     * 时间: 下午5:17
     **/
    public int updateResources(SysResource sysResource) {
        return sysResourceDAO.updateByPrimaryKeySelective(sysResource);
    }
    /**
     * 类名:
     * 参数: 
     * 描述: 启用资源
     * 作者: gongwang
     * 日期: 2018/1/24
     * 时间: 下午5:18
     **/
    public int enableRes(Long resId) {
        SysResource sysResource = new SysResource();
        sysResource.setId(resId);
        sysResource.setAvailable((byte)1);
        return sysResourceDAO.updateByPrimaryKeySelective(sysResource);
    }

    public Integer getResTotalCount() {
        return sysResourceDAO.selectCount(new SysResource());
    }
}

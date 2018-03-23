package com.gw.seckill.web.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.gw.seckill.common.web.exception.pojo.Result;
import com.gw.seckill.facade.admin.entity.SysResource;
import com.gw.seckill.facade.admin.entity.SysRole;
import com.gw.seckill.facade.admin.service.ResourceFacade;
import com.gw.seckill.facade.admin.service.RoleFacade;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 类名: RoleController
 * 包名: com.gw.seckill.web.admin.controller
 * 描述: 角色管理Controller
 * 作者: gongwang
 * 创建日期: 2018/2/8
 * 创建时间: 下午12:48
 **/
@Controller
public class RoleController {
    @Reference(version = "1.0.0")
    private RoleFacade roleFacade;
    @Reference(version = "1.0.0")
    private ResourceFacade resourceFacade;

    /**
     * 类名:
     * 参数: 
     * 描述: 角色展示列表
     * 作者: gongwang
     * 日期: 2018/2/12
     * 时间: 上午9:03
     **/
    @RequiresPermissions("role:view")
    @RequestMapping("/role/view")
    public String showRolePage(@RequestParam Integer page, Model model){
        SysRole sysRole = new SysRole();
        sysRole.setPage(page);
        sysRole.setRows(15);
        PageInfo<SysRole> pageInfo = roleFacade.getAllRolesPaged(sysRole);
        model.addAttribute("pageInfo",pageInfo);
        return "/role/role";
    }
    /**
     * 类名:
     * 参数: 
     * 描述: 添加角色页面
     * 作者: gongwang
     * 日期: 2018/2/12
     * 时间: 上午9:03
     **/
    @RequiresPermissions("role:create")
    @RequestMapping("/role/create")
    public String addRolePage(Model model){
        List<SysResource> resList = resourceFacade.getAllResources();
        model.addAttribute("resList",resList);
        return "/role/add_role_page";
    }

    /**
    　* @描述:     添加角色操作
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/2 14:33
      */
    @RequiresPermissions("role:create")
    @RequestMapping("/role/create.do")
    @ResponseBody
    public Result addRole(@RequestBody SysRole sysRole, Model model){
        Result result = new Result();
        if(sysRole!=null){
            int row = roleFacade.addRole(sysRole);
            if(row == 1){
                result.setStatus(0);
                result.setMsg("添加成功!");
                return result;
            }
        }
        result.setStatus(-1);
        result.setMsg("添加失败!");
        return result;
    }

    /**
    　* @描述:     删除角色
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/2 14:45
      */
    @RequiresPermissions("role:delete")
    @RequestMapping("/role/delete")
    @ResponseBody
    public Result delRole(@RequestBody Long id,Model model){
        Result result = new Result();
        if(id != null){
            int row = roleFacade.delRoleById(id);
            if(row == 1){
                result.setStatus(0);
                result.setMsg("删除成功!");
                return result;
            }
        }
        result.setStatus(-1);
        result.setMsg("删除失败!");
        return result;
    }

    /**
    　* @描述:     启用角色
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/2 15:14
      */
    @RequiresPermissions("role:update")
    @RequestMapping("/role/enable.do")
    @ResponseBody
    public Result enableRole(@RequestBody Long id){
        Result result = new Result();
        if(id != null){
            int row = roleFacade.enableRoleById(id);
            if(row == 1){
                result.setStatus(0);
                result.setMsg("启用成功!");
                return result;
            }
        }
        result.setStatus(-1);
        result.setMsg("启用失败!");
        return result;
    }
    /**
    　* @描述:    跳转到修改页面
    　* @参数描述: 
    　* @返回值:   
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/5 18:44
      */
    @RequiresPermissions("role:update")
    @RequestMapping("/role/update")
    public String toEditPage(@RequestParam Long id,Model model){
        if(id != null){
            SysRole role = roleFacade.getRoleById(id);
            List<SysResource> resList = resourceFacade.getAllResources();
            if(role != null){
                model.addAttribute("role",role);
                model.addAttribute("resList",resList);
                return "/role/edit_role_page";
            }
        }
        return null;
    }

    /**
    　* @描述:     修改角色信息
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/5 18:43
      */
    @RequiresPermissions("role:update")
    @RequestMapping("/role/update.do")
    @ResponseBody
    public Result editRole(@RequestBody SysRole sysRole, Model model){
        Result result = new Result();
        if(sysRole!=null){
            int row = roleFacade.updateRole(sysRole);
            if(row == 1){
                result.setStatus(0);
                result.setMsg("修改成功!");
                return result;
            }
        }
        result.setStatus(-1);
        result.setMsg("修改失败!");
        return result;
    }

}

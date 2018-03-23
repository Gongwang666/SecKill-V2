package com.gw.seckill.web.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.gw.seckill.common.web.exception.pojo.Result;
import com.gw.seckill.facade.admin.entity.SysRole;
import com.gw.seckill.facade.admin.entity.SysUser;
import com.gw.seckill.facade.admin.service.RoleFacade;
import com.gw.seckill.facade.admin.service.UserFacade;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 类名: UserManagerController
 * 包名: com.gw.seckill.web.admin.controller
 * 描述: 用户管理Controller
 * 作者: gongwang
 * 创建日期: 2018/1/26
 * 创建时间: 下午4:12
 **/
@Controller
public class UserManagerController {
    @Reference(version = "1.0.0")
    private UserFacade userFacade;
    @Reference(version = "1.0.0")
    private RoleFacade roleFacade;
    /**
     * 类名:
     * 参数: 
     * 描述: 添加用户页面
     * 作者: gongwang
     * 日期: 2018/1/26
     * 时间: 下午4:19
     **/
    @RequiresPermissions("sysuser:create")
    @RequestMapping("/sysuser/create")
    public String addSysUserPage(Model model){
        List<SysRole> roleList = roleFacade.getAllRoles();
        if(roleList!=null&&roleList.size()>0){
            model.addAttribute("roleList",roleList);
        }
        return "/sysuser/add_sysUser_page";
    }
    /**
     * 类名:
     * 参数: 
     * 描述: 添加用户动作
     * 作者: gongwang
     * 日期: 2018/1/26
     * 时间: 下午4:20
     **/
    @RequiresPermissions("sysuser:create")
    @ResponseBody
    @RequestMapping("/sysuser/create.do")
    public Result addSysUser(@RequestBody SysUser sysUser){
        Result result = new Result();
        try {
            if(sysUser!=null){
                int insertResult = userFacade.addSysUser(sysUser);
                if(insertResult == 1){
                    result.setStatus(0);
                    result.setMsg("添加成功！");
                    return result;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(-1);
            result.setMsg("用户名已经存在!");
            return result;
        }
        result.setStatus(-1);
        result.setMsg("添加出现未知错误!");
        return result;
    }
    /**
     * 类名:
     * 参数: 
     * 描述: 查看用户页面
     * 作者: gongwang
     * 日期: 2018/1/26
     * 时间: 下午4:22
     **/
    @RequiresPermissions("sysuser:view")
    @RequestMapping("/sysuser/view")
    public String showSysUserPage(@RequestParam Integer page, Model model){
        SysUser sysUser = new SysUser();
        sysUser.setPage(page);
        sysUser.setRows(15);
        PageInfo<SysUser> pageInfo = userFacade.getAllUsersPaged(sysUser);
        model.addAttribute("pageInfo",pageInfo);
        return "/sysuser/sysUser";
    }
    /**
     * 类名:
     * 参数: 
     * 描述: 解锁用户账号
     * 作者: gongwang
     * 日期: 2018/1/26
     * 时间: 下午7:50
     **/
    @ResponseBody
    @RequiresPermissions("sysuser:update")
    @RequestMapping("/sysuser/deblocking.do")
    public Result deBlockingUser(@RequestBody Long userID){
        Result result = new Result();
        if(userID != null){
            int updateResult = userFacade.deBlockingUser(userID);
            if(updateResult == 1){
                result.setStatus(0);
                result.setMsg("解锁成功");
                return result;
            }
        }
        result.setMsg("解锁失败!");
        result.setStatus(-1);
        return result;
    }
    /**
     * 类名:
     * 参数: 
     * 描述: 停用用户
     * 作者: gongwang
     * 日期: 2018/1/26
     * 时间: 下午8:33
     **/
    @ResponseBody
    @RequiresPermissions("sysuser:update")
    @RequestMapping("/sysuser/blocking.do")
    public Result blockingUser(@RequestBody Long userID){
        Result result = new Result();
        if(userID != null){
            int updateResult = userFacade.blockingUser(userID);
            if(updateResult == 1){
                result.setStatus(0);
                result.setMsg("停用成功");
                return result;
            }
        }
        result.setMsg("停用失败!");
        result.setStatus(-1);
        return result;
    }
}

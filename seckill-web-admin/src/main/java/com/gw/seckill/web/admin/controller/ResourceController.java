package com.gw.seckill.web.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.gw.seckill.common.web.exception.enums.ExceptionEnum;
import com.gw.seckill.common.web.exception.pojo.Result;
import com.gw.seckill.common.web.exception.utils.ResultUtil;
import com.gw.seckill.facade.admin.entity.SysResource;
import com.gw.seckill.facade.admin.entity.SysUser;
import com.gw.seckill.facade.admin.service.MenuFacade;
import com.gw.seckill.facade.admin.service.ResourceFacade;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class ResourceController {
    @Reference(version = "1.0.0")
    private ResourceFacade resourceFacade;

    /**
    　* @描述:     资源浏览页面
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/10 16:52
      */
    @RequiresPermissions("resource:view")
    @RequestMapping("/resource/view")
    public String showAllRes(@RequestParam Integer page, Model model){
        SysResource sysResource = new SysResource();
        sysResource.setRows(15);
        sysResource.setPage(page);
        PageInfo<SysResource> pageInfo = resourceFacade.getAllResourcesPaged(sysResource);
        model.addAttribute("pageInfo",pageInfo);
        return "/resource/resource";
    }
    /**
    　* @描述:     跳转到添加资源页面
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/10 16:18
      */
    @RequiresPermissions("resource:create")
    @RequestMapping("/resource/create")
    public String addResPage(Model model){
        Subject subject = SecurityUtils.getSubject();
        String userName =(String) subject.getPrincipal();
        boolean flag =subject.isPermitted("resource:view");
        model.addAttribute("resList",resourceFacade.getAllResources());
        return "/resource/add_res_page";
    }
    /**
    　* @描述:     添加操作
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/10 16:18
      */
    @ResponseBody
    @RequestMapping("/resource/create.do")
    public Result addRes(@RequestBody SysResource sysResource, Model model){
        if(sysResource != null){
            resourceFacade.addSysRes(sysResource);
            return ResultUtil.success();
        }
        return ResultUtil.error(ExceptionEnum.ADD_ERROR);
    }
    /**
    　* @描述:     删除资源
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/10 22:08
      */
    @RequiresPermissions("resource:delete")
    @ResponseBody
    @RequestMapping("/resource/delete")
    public Result delRes(@RequestBody Long resID){
        if(resID != null){
            SysResource sysResource = resourceFacade.getResourcesByID(resID);
            String url = sysResource.getResUrl();
            Result result = new Result();
            if(url.equals("/resource")||url.equals("/resource/view")){
                result.setStatus(-1);
                result.setMsg("该资源不能被删除！");
                result.setData(resID);
                return result;
            }
            resourceFacade.deleteSysResource(resID);
            result = new Result();
            result.setStatus(0);
            result.setMsg("删除成功!");
            result.setData(resID);
            return result;
        }
        return ResultUtil.error(ExceptionEnum.ADD_ERROR);
    }

    @RequiresPermissions("resource:update")
    @RequestMapping("/resource/update")
    /**
     * 类名: editRes
     * 参数: [sysResource]
     * 描述: 修改资源信息页面
     * 作者: gongwang
     * 日期: 2018/1/24
     * 时间: 下午2:27
     **/
    public String editResPage(@RequestParam Long resID,Model model){
        if(resID != null){
            model.addAttribute("resourceInfo",resourceFacade.getResourcesByID(resID));
            model.addAttribute("resList",resourceFacade.getAllResources());
            return "/resource/edit_res_page";
        }
        return null;
    }
    @RequiresPermissions("resource:update")
    @RequestMapping("/resource/update.do")
    @ResponseBody
    /**
     * 类名: editRes
     * 参数: [resID, model]
     * 描述: 执行修改操作
     * 作者: gongwang
     * 日期: 2018/1/24
     * 时间: 下午3:36
     **/
    public Result editRes(@RequestBody SysResource sysResource,Model model){
        Result result = new Result();
        int code = resourceFacade.updateResources(sysResource);
        if(code == 1){
            result.setStatus(0);
            result.setMsg("添加成功！");
            return result;
        }
        result.setStatus(-1);
        result.setMsg("添加遇到未知错误！");
        return result;
    }
    /**
     * 类名:
     * 参数: 
     * 描述: 启用资源
     * 作者: gongwang
     * 日期: 2018/1/24
     * 时间: 下午5:10
     **/
    @RequiresPermissions("resource:update")
    @ResponseBody
    @RequestMapping("/resource/enable.do")
    public Result enableRes(@RequestBody Long resId){
        Result result = new Result();
        int num = resourceFacade.enableRes(resId);
        return result;
    }
}

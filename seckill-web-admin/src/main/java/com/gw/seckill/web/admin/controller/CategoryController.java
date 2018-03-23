package com.gw.seckill.web.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.gw.seckill.common.web.exception.pojo.Result;
import com.gw.seckill.facade.admin.entity.GoodsCats;
import com.gw.seckill.facade.admin.service.GoodsCatsFacade;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
　* @描述:     商品菜单管理Controller
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/3/5 20:24
  */
@Controller
public class CategoryController {
    @Reference(version = "1.0.0")
    private GoodsCatsFacade goodsCatsFacade;
    
    /**
    　* @描述:     查看所有分类
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/6 10:49
      */
    @RequiresPermissions("cats:view")
    @RequestMapping("/goods/cats/view")
    public String showAllCats(@RequestParam Integer page, Model model){
        GoodsCats goodsCats = new GoodsCats();
        goodsCats.setPage(page);
        goodsCats.setRows(15);
        PageInfo<GoodsCats> pageInfo = goodsCatsFacade.getAllCatsPaged(goodsCats);
        model.addAttribute("pageInfo",pageInfo);
        return "/category/category";
    }
    @RequiresPermissions("cats:create")
    @RequestMapping("/goods/cats/create")
    public String addCatsPage(Model model){
        List<GoodsCats> catsList = goodsCatsFacade.getAllGoodCats();
        model.addAttribute("catsList",catsList);
        return "/category/add_cat_page";
    }
    /**
    　* @描述:     添加分类
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/6 10:57
      */
    @RequiresPermissions("cats:create")
    @RequestMapping("/goods/cats/create.do")
    @ResponseBody
    public Result addCats(@RequestBody GoodsCats goodsCats){
        Result result = new Result();
        if(goodsCats != null){
            int row = goodsCatsFacade.addCats(goodsCats);
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
    　* @描述:     删除分类信息
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/6 14:38
      */
    @RequiresPermissions("cats:delete")
    @RequestMapping("/goods/cats/delete")
    @ResponseBody
    public Result delCats(@RequestBody Long id){
        Result result = new Result();
        if(id != null){
            int row = goodsCatsFacade.delCat(id);
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
    　* @描述:     跳转到编辑页面
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/6 15:16
      */
    @RequiresPermissions("cats:update")
    @RequestMapping("/goods/cats/update")
    public String toEditPage(@RequestParam Long id,Model model){
        GoodsCats goodsCats = goodsCatsFacade.getCatsById(id);
        GoodsCats parentCats = goodsCatsFacade.getCatsById(goodsCats.getParentId());
        List<GoodsCats> catsList = goodsCatsFacade.getAllGoodCats();
        model.addAttribute("catsList",catsList);
        if(goodsCats != null){
            model.addAttribute("goodsCats",goodsCats);
            model.addAttribute("parentCats",parentCats);
        }
        return "/category/edit_cat_page";
    }
    /**
    　* @描述:     修改操作
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/6 15:23
      */
    @RequiresPermissions("cats:update")
    @RequestMapping("/goods/cats/update.do")
    @ResponseBody
    public Result editCats(@RequestBody GoodsCats goodsCats){
        Result result = new Result();
        if(goodsCats != null){
            int row = goodsCatsFacade.editCat(goodsCats);
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

    @RequiresPermissions("cats:update")
    @RequestMapping("/goods/cats/enable.do")
    @ResponseBody
    public Result enableCats(@RequestBody Long id){
        Result result = new Result();
        if(id != null){
            int row = goodsCatsFacade.enableCats(id);
            if(row == 1){
                result.setStatus(0);
                result.setMsg("启用成功!");
                return result;
            }
        }
        result.setStatus(-1);
        result.setMsg("启用成功!");
        return result;
    }
}

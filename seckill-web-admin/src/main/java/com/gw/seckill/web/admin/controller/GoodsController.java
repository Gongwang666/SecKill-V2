package com.gw.seckill.web.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.gw.seckill.common.web.exception.pojo.Result;
import com.gw.seckill.common.web.fastdfs.utils.FastDFSClientWrapper;
import com.gw.seckill.constants.ConstantClassFunction;
import com.gw.seckill.facade.admin.entity.Goods;
import com.gw.seckill.facade.admin.entity.GoodsCats;
import com.gw.seckill.facade.admin.entity.GoodsImg;
import com.gw.seckill.facade.admin.service.GoodsCatsFacade;
import com.gw.seckill.facade.admin.service.GoodsFacade;
import com.gw.seckill.facade.admin.service.GoodsImgFacade;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
　* @描述:     商品信息管理Controller
　* @参数描述: 
　* @返回值:
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/3/7 10:30
  */
@Controller
public class GoodsController {
    @Reference(version = "1.0.0")
    private GoodsFacade goodsFacade;
    @Reference(version = "1.0.0")
    private GoodsImgFacade goodsImgFacade;
    @Autowired
    private FastDFSClientWrapper dfsClient;
    @Reference(version = "1.0.0")
    private GoodsCatsFacade goodsCatsFacade;

    @RequiresPermissions("goodsInfo:view")
    @RequestMapping("/goods/goodsInfo/view")
    public String showAllGoods(@RequestParam Integer page, Model model){
        Goods goods = new Goods();
        goods.setPage(page);
        goods.setRows(16);
        PageInfo<Goods> pageInfo = goodsFacade.getAllGoodsPaged(goods);
        model.addAttribute("pageInfo",pageInfo);
        return "/goods/goods";
    }

    @RequiresPermissions("goodsInfo:create")
    @RequestMapping("/goods/goodsInfo/create")
    public String addGoodsPage(Model model){
        List<GoodsCats> catsList = goodsCatsFacade.getAllGoodCats();
        model.addAttribute("catsList",catsList);
        return "/goods/add_goods_page";
    }

    @RequiresPermissions("goodsInfo:create")
    @RequestMapping("/goods/goodsInfo/create.do")
    @ResponseBody
    public Result addGoods(@RequestBody Goods goods){
        Result result = new Result();
        if(goods != null){
            int row = goodsFacade.addGoods(goods);
            if(row == 1){
                result.setStatus(0);
                result.setMsg("添加成功");
                return result;
            }
        }
        result.setStatus(-1);
        result.setMsg("添加失败");
        return result;
    }
    /**
    　* @描述:     跳转到商品图片管理页面
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/15 19:06
      */
    @RequiresPermissions("goodsInfo:view")
    @RequestMapping("/goods/goodsInfo/imgManage")
    public String goodsImgsPage(@RequestParam Integer page,Model model){
        if(page != null){
            Goods goods = new Goods();
            goods.setPage(page);
            goods.setRows(15);
            PageInfo<Goods> pageInfo = goodsFacade.getAllGoodsPagedWithImgs(goods);
            model.addAttribute("pageInfo",pageInfo);
        }
        return "/goods/img_manager";
    }
    /**
    　* @描述:     商品图片展示列表
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/20 14:11
      */
    @RequiresPermissions("goodsInfo:view")
    @RequestMapping("/goods/goodsInfo/imgPage")
    public String goodsImgManagerPage(@RequestParam Integer page,@RequestParam Long id,Model model){
        GoodsImg goodsImg = new GoodsImg();
        goodsImg.setGoodsID(id);
        goodsImg.setPage(page);
        goodsImg.setRows(15);
        PageInfo<GoodsImg> pageInfo = goodsImgFacade.getAllImgPaged(goodsImg);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("goodsID",id);
        return "/goods/goods_img_manager";
    }

    @RequiresPermissions("goodsInfo:view")
    @RequestMapping("/goods/goodsInfo/uploadFile")
    public String goodsImgUploadPage(@RequestParam Long id,Model model){
        model.addAttribute("goodsID",id);
        return "/goods/img_manager_page";
    }
    /**
    　* @描述:     文件上传动作
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/20 14:11
      */
    @RequiresPermissions("goodsInfo:create")
    @RequestMapping("/goods/goodsInfo/uploadFile.do")
    @ResponseBody
    public Result uploadImg(@RequestBody MultipartFile file,Long goodsID) throws Exception{
        Result result = new Result();
        if(file != null && goodsID != null){
            GoodsImg goodsImg = new GoodsImg();
            String imgUrl = ConstantClassFunction.getFILE_UPLOAD_URL()+dfsClient.uploadFile(file);
            goodsImg.setGoodsID(goodsID);
            goodsImg.setImgUrl(imgUrl);
            goodsImg.setUploadDate(new Date());

            int row = goodsImgFacade.addImg(goodsImg);
            if(row == 1){
                result.setStatus(0);
                result.setMsg("上传成功!");
                return result;
            }

        }
        result.setStatus(-1);
        result.setMsg("上传失败!");
        return result;
    }
    /**
    　* @描述:     删除图片
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/20 15:27
      */
    @RequiresPermissions("goodsInfo:create")
    @RequestMapping("/goods/goodsInfo/delFile.do")
    @ResponseBody
    public Result delImg(String idsArray) throws Exception{
        Result result = new Result();
        List<Long> ids = JSONObject.parseArray(idsArray,Long.class);
        if(ids !=null && ids.size()>0){
            //删除图片服务器的文件
            for(int i = 0; i < ids.size(); i++){
                GoodsImg goodsImg = goodsImgFacade.getImgById(ids.get(i));
                dfsClient.deleteFile(goodsImg.getImgUrl());
            }
            int rows = goodsImgFacade.delImg(ids.toArray(new Long[0]));
            if(rows == ids.size()){
                result.setStatus(0);
                result.setMsg("删除成功!");
                return result;
            }

        }
        result.setStatus(-1);
        result.setMsg("删除失败!");
        return result;
    }

    @RequestMapping("/goods/goodsInfo/getCatIdPath")
    @ResponseBody
    public String getCatIdPath(Long id){
        Map<String,String> map = new HashMap<String,String>();
        if(id != null){
            String path = goodsCatsFacade.getCatIdPath(id);
            map.put("path",path);
            return JSON.toJSONString(map);
        }
        map.put("msg","出错了");
        return JSON.toJSONString(map);
    }
}

package com.gw.seckill.core.admin.util;

import com.gw.seckill.utils.TreeService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GoodsCatsUtil extends TreeService {
    /**
    　* @描述:     反转路径
    　* @参数描述: 
    　* @返回值:   
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/3/21 20:47
      */
    public String reversalPath(String path){
        String[] ids = path.split("/");
        List<String> list = Arrays.asList(ids);
        Collections.reverse(list);
        String newPath = "";
        for(String str : list){
            newPath += "/"+str;
        }
        return newPath;
    }
}

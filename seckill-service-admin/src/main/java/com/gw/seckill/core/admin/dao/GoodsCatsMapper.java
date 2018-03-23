package com.gw.seckill.core.admin.dao;

import com.gw.seckill.common.core.dao.BaseMapper;
import com.gw.seckill.facade.admin.entity.GoodsCats;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository("goodsCatsDAO")
@Mapper
public interface GoodsCatsMapper extends BaseMapper<GoodsCats> {
    /*int deleteByPrimaryKey(Integer catId);

    int insert(GoodsCats record);

    int insertSelective(GoodsCats record);
    
    *//**
    　* @描述:     通过主键查询数据库中分类信息
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/2 15:10
      *//*
    GoodsCats selectByPrimaryKey(Integer catId);

    *//**
    　* @描述:     查询数据库中分类表中的所有信息
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/2 15:09
      *//*
    List<GoodsCats> selectAllCats();
    *//**
    　* @描述:     查询数据库表PARENT_ID字段为parentId的所有记录
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/2 15:06
      *//*
    List<GoodsCats> selectCatsByParentId(Integer parentId);
    
    *//**
    　* @描述:     查找所有根分类
    　* @参数描述: 
    　* @返回值:
    　* @异常:     
    　* @作者:     gongwang
    　* @创建时间: 2018/1/2 15:12
      *//*
    List<GoodsCats> selectAllRootCats();

    int updateByPrimaryKeySelective(GoodsCats record);

    int updateByPrimaryKey(GoodsCats record);*/
}
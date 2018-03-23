package com.gw.seckill.utils;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：基层树形结构实体类--ID AND PARENTID AND CHILDSLIST
 * 作者： xfz
 * 时间：2016年7月2日
 * 版本号：1.0
 */
public class BaseTreeObj<E, ID extends Serializable> implements Serializable {
    private static final long serialVersionUID = 1L;
    @JSONField(serialize = false)
    private ID id;
    @JSONField(serialize = false)
    private ID parentId;
    private List<E> products = new ArrayList<E>();

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public ID getParentId() {
        return parentId;
    }

    public void setParentId(ID parentId) {
        this.parentId = parentId;
    }

    public List<E> getProducts() {
        return products;
    }

    public void setProducts(List<E> products) {
        this.products = products;
    }
}
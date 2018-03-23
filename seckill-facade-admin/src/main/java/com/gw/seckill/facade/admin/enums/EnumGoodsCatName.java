package com.gw.seckill.facade.admin.enums;

public enum  EnumGoodsCatName {
    FIRST(-1,"一级菜单"),SECOND(0,"二级菜单");

    private Integer index;
    private String name;
    EnumGoodsCatName(Integer index,String name) {
        this.index = index;
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

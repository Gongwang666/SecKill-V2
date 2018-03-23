package com.gw.seckill.facade.admin.enums;

public enum EnumTreeType {
    FOLDER(0,"folder"),ITEM(1,"item");
    private Integer index;
    private String name;
    EnumTreeType(int index, String name) {
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

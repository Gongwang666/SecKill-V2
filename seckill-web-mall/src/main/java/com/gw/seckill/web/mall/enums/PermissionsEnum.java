package com.gw.seckill.web.mall.enums;

public enum  PermissionsEnum {
    LOGIN_PAGE("/loginPage"),
    LOGIN("/login");
    private String url;
    PermissionsEnum(String url){
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

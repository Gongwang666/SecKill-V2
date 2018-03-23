package com.gw.seckill.web.admin.enums;
/**
　* @描述:     不需要权限的URL枚举类
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/1/16 20:11
  */
public enum EnumWithOutPermissionUrls {
    //前往登录页面
    LOGIN_PAGE("/user/login"),
    //登录操作
    DO_LOGIN("/user/login.do"),
    //登出操作
    DO_LOGOUT("/user/logout.do"),
    //前往未授权提示页面
    UNAUTHER_PAGE("/unauthor"),
    //错误提示
    ERROR_INFO("/404"),
    //踢出用户
    USER_KICK_OUT("/user/kickout"),
    //menu
    MENU("/menu");
    private String url;

    EnumWithOutPermissionUrls(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

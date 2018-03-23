package com.gw.seckill.common.web.exception.enums;
/**
　* @描述:     错误枚举类
　* @异常:     
　* @作者:     gongwang
　* @创建时间: 2018/1/5 14:43
  */
public enum ExceptionEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    ADD_ERROR(-2,"添加错误"),
    USER_NOT_FIND(-101,"用户名或密码错误"),
    USER_LOGIN_ERROR(-3,"用户登录错误"),
    ;

    private Integer code;

    private String msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
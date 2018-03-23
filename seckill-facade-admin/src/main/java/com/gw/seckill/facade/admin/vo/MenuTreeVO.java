package com.gw.seckill.facade.admin.vo;

import com.gw.seckill.utils.BaseTreeObj;

public class MenuTreeVO extends BaseTreeObj<MenuTreeVO,Long>{
    private String title;
    private String type;
    private String url;

    public MenuTreeVO() {
    }

    public MenuTreeVO(String title, String type,String url) {
        this.title = title;
        this.type = type;
        this.url = url;

    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

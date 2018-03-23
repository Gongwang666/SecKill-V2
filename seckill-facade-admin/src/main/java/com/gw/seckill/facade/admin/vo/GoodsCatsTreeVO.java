package com.gw.seckill.facade.admin.vo;

import com.gw.seckill.facade.admin.entity.GoodsCats;
import com.gw.seckill.utils.BaseTreeObj;

public class GoodsCatsTreeVO extends BaseTreeObj<GoodsCatsTreeVO,Long>{
    private GoodsCats goodsCats;

    public GoodsCats getGoodsCats() {
        return goodsCats;
    }

    public void setGoodsCats(GoodsCats goodsCats) {
        this.goodsCats = goodsCats;
    }
}

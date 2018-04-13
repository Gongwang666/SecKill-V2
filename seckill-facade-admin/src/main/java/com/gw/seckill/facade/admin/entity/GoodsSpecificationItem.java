package com.gw.seckill.facade.admin.entity;

import com.gw.seckill.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
@Table(name="goods_spec_items")
public class GoodsSpecificationItem extends BaseEntity implements Serializable {
    @Column(name = "SPEC_ITEM_NAME")
    private String specItemName;
    @Column(name = "SPEC_ID")
    private Long specId;

    public String getSpecItemName() {
        return specItemName;
    }

    public void setSpecItemName(String specItemName) {
        this.specItemName = specItemName;
    }

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }
}

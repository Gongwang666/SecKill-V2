package com.gw.seckill.facade.admin.entity;

import com.gw.seckill.entity.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Goods extends BaseEntity implements Serializable{

    @Column(name = "GOODS_SN")
    private String goodsSn;

    @Column(name = "GOODS_NAME")
    private String goodsName;

    @Column(name = "GOODS_IMG")
    private String goodsImg;

    @Column(name = "MARKET_PRICE")
    private Long marketPrice;

    @Column(name = "SHOP_PRICE")
    private Long shopPrice;

    @Column(name = "WARN_STOCK")
    private Integer warnStock;

    @Column(name = "GOODS_STOCK")
    private Integer goodsStock;

    @Column(name = "GOODS_TIPS")
    private String goodsTips;

    @Column(name = "IS_SALE")
    private Byte isSale;

    @Column(name = "IS_BEST")
    private Byte isBest;

    @Column(name = "IS_HOT")
    private Byte isHot;

    @Column(name = "IS_NEW")
    private Byte isNew;

    @Column(name = "GOODS_CAT_ID_PATH")
    private String goodsCatIdPath;

    @Column(name = "GOODS_CAT_ID")
    private Integer goodsCatId;

    @Column(name = "GOODS_DESC")
    private String goodsDesc;

    @Column(name = "SALE_NUM")
    private Integer saleNum;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "SALE_TIME")
    private Date saleTime;

    @Column(name = "DATA_FLAG")
    private Byte dataFlag;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "CREATE_TIME")
    private Date createTime;
    @Transient
    private List<GoodsImg> goodsImgList;


    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn == null ? null : goodsSn.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }

    public Long getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Long marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Long getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Long shopPrice) {
        this.shopPrice = shopPrice;
    }

    public Integer getWarnStock() {
        return warnStock;
    }

    public void setWarnStock(Integer warnStock) {
        this.warnStock = warnStock;
    }

    public Integer getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }

    public String getGoodsTips() {
        return goodsTips;
    }

    public void setGoodsTips(String goodsTips) {
        this.goodsTips = goodsTips == null ? null : goodsTips.trim();
    }

    public Byte getIsSale() {
        return isSale;
    }

    public void setIsSale(Byte isSale) {
        this.isSale = isSale;
    }

    public Byte getIsBest() {
        return isBest;
    }

    public void setIsBest(Byte isBest) {
        this.isBest = isBest;
    }

    public Byte getIsHot() {
        return isHot;
    }

    public void setIsHot(Byte isHot) {
        this.isHot = isHot;
    }

    public Byte getIsNew() {
        return isNew;
    }

    public void setIsNew(Byte isNew) {
        this.isNew = isNew;
    }

    public String getGoodsCatIdPath() {
        return goodsCatIdPath;
    }

    public void setGoodsCatIdPath(String goodsCatIdPath) {
        this.goodsCatIdPath = goodsCatIdPath == null ? null : goodsCatIdPath.trim();
    }

    public Integer getGoodsCatId() {
        return goodsCatId;
    }

    public void setGoodsCatId(Integer goodsCatId) {
        this.goodsCatId = goodsCatId;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc == null ? null : goodsDesc.trim();
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    public Byte getDataFlag() {
        return dataFlag;
    }

    public void setDataFlag(Byte dataFlag) {
        this.dataFlag = dataFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<GoodsImg> getGoodsImgList() {
        return goodsImgList;
    }

    public void setGoodsImgList(List<GoodsImg> goodsImgList) {
        this.goodsImgList = goodsImgList;
    }
}
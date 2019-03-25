package com.boot.security.server.model;

import java.math.BigDecimal;

public class Goods extends BaseEntity<Long> {

// 商品编号;
    private String goodsNo;
// 商品类型;
    private Integer type;
// 商品名称;
    private String name;
// 商品出厂价格;
    private BigDecimal price;
// 商品介绍;
    private String introduce;
// 商品视频url;
    private String videoUrl;
// 商品图片地址;
    private String listImageUrl;
// 商品图片集合ID;
    private Integer imageId;
// 商铺ID;
    private Integer storeId;
// 商品规格;
    private String specification;
// 商品库存;
    private Integer stock;
// 商品成本价;
    private BigDecimal costPrice;
// 商品进货价;
    private BigDecimal buyingPrice;
// 商品市场价格;
    private BigDecimal marketPrice;
//商品证书	
    private String diploma;

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getListImageUrl() {
        return listImageUrl;
    }

    public void setListImageUrl(String listImageUrl) {
        this.listImageUrl = listImageUrl;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(BigDecimal buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

}

package com.boot.security.server.model;

public class GoodsImages extends BaseEntity<Long> {

// 第一张图片;
    private String imageoneUrl;
// 第二张图片;
    private String imagetwoUrl;
// 第三张图片;
    private String imagethreeUrl;
// 第四张图片;
    private String imagefourUrl;
// 第五张图片;
    private String imagefiveUrl;
// 第六张图片;
    private String imagesixUrl;
// 第七张图片;
    private String imagesevenUrl;
// 第八张图片;
    private String imageeightUrl;

    private Integer goodsId;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getImageoneUrl() {
        return imageoneUrl;
    }

    public void setImageoneUrl(String imageoneUrl) {
        this.imageoneUrl = imageoneUrl;
    }

    public String getImagetwoUrl() {
        return imagetwoUrl;
    }

    public void setImagetwoUrl(String imagetwoUrl) {
        this.imagetwoUrl = imagetwoUrl;
    }

    public String getImagethreeUrl() {
        return imagethreeUrl;
    }

    public void setImagethreeUrl(String imagethreeUrl) {
        this.imagethreeUrl = imagethreeUrl;
    }

    public String getImagefourUrl() {
        return imagefourUrl;
    }

    public void setImagefourUrl(String imagefourUrl) {
        this.imagefourUrl = imagefourUrl;
    }

    public String getImagefiveUrl() {
        return imagefiveUrl;
    }

    public void setImagefiveUrl(String imagefiveUrl) {
        this.imagefiveUrl = imagefiveUrl;
    }

    public String getImagesixUrl() {
        return imagesixUrl;
    }

    public void setImagesixUrl(String imagesixUrl) {
        this.imagesixUrl = imagesixUrl;
    }

    public String getImagesevenUrl() {
        return imagesevenUrl;
    }

    public void setImagesevenUrl(String imagesevenUrl) {
        this.imagesevenUrl = imagesevenUrl;
    }

    public String getImageeightUrl() {
        return imageeightUrl;
    }

    public void setImageeightUrl(String imageeightUrl) {
        this.imageeightUrl = imageeightUrl;
    }

}

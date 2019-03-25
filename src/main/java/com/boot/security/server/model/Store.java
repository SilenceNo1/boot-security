package com.boot.security.server.model;

public class Store extends BaseEntity<Long> {

    /** serialVersionUID */
    private static final long serialVersionUID = 1073052644260112855L;

    // 店铺名称
    private String name;
    // 用户ID
    private Integer userId;
    // 店铺地址
    private String address;
    // 联系人
    private String contacts;
    // 运营时间
    private String businessHours = "营业时间 9:00AM--6:00PM";
    // 所属城市名称
    private String areaName = "北京市";
    // 店铺位置经度
    private String longitude;
    // 店铺位置纬度
    private String latitude;
    // 微信ID
    private String wechatId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setuUerId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

}

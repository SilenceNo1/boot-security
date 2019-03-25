package com.boot.security.server.model;

import java.util.Date;

public class TUser extends BaseEntity<Long> {

// 真实姓名;
    private String name;
// 昵称;
    private String nickName;
// 手机号;
    private String mobile;
// 密码;
    private String password;
// 生日;
    private String birthday;
// 性别;
    private String sex;
// 邮箱;
    private String email;
// 头像;
    private String photoUrl;
// QQid;
    private String tencentName;
// 绑定QQ账号;
    private String tencentId;
// 微信ID;
    private String wechatId;
// 微信名称;
    private String wechatName;
// 微信头像;
    private String wechatPhotourl;
// 新浪ID;
    private String sinaId;
// 新浪名称;
    private String sinaName;
// 推荐码;
    private String userCode;
// 会员等级;
    private Integer equityId = 0;
// 最后登录时间;
    private Date lastVisitTime;
// 登陆天数;
    private Integer loginDays = 0;
// 新手奖励;
    private Integer noviceAward = 0;
// 登陆时间;
    private Date loginTime;
// 身份证号;
    private String idCard;
// 福利资格;
    private Integer welfareStatus = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getTencentName() {
        return tencentName;
    }

    public void setTencentName(String tencentName) {
        this.tencentName = tencentName;
    }

    public String getTencentId() {
        return tencentId;
    }

    public void setTencentId(String tencentId) {
        this.tencentId = tencentId;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getWechatName() {
        return wechatName;
    }

    public void setWechatName(String wechatName) {
        this.wechatName = wechatName;
    }

    public String getWechatPhotourl() {
        return wechatPhotourl;
    }

    public void setWechatPhotourl(String wechatPhotourl) {
        this.wechatPhotourl = wechatPhotourl;
    }

    public String getSinaId() {
        return sinaId;
    }

    public void setSinaId(String sinaId) {
        this.sinaId = sinaId;
    }

    public String getSinaName() {
        return sinaName;
    }

    public void setSinaName(String sinaName) {
        this.sinaName = sinaName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Integer getEquityId() {
        return equityId;
    }

    public void setEquityId(Integer equityId) {
        this.equityId = equityId;
    }

    public Date getLastVisitTime() {
        return lastVisitTime;
    }

    public void setLastVisitTime(Date lastVisitTime) {
        this.lastVisitTime = lastVisitTime;
    }

    public Integer getLoginDays() {
        return loginDays;
    }

    public void setLoginDays(Integer loginDays) {
        this.loginDays = loginDays;
    }

    public Integer getNoviceAward() {
        return noviceAward;
    }

    public void setNoviceAward(Integer noviceAward) {
        this.noviceAward = noviceAward;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getWelfareStatus() {
        return welfareStatus;
    }

    public void setWelfareStatus(Integer welfareStatus) {
        this.welfareStatus = welfareStatus;
    }

}

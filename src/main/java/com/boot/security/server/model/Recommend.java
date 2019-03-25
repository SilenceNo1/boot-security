package com.boot.security.server.model;

public class Recommend extends BaseEntity<Long> {

// 用户ID;
    private Integer userId;
// 直推码;
    private Integer pushStraight;
// 间推码;
    private Integer pushBetween;
// 三推码;
    private Integer threePush;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPushStraight() {
        return pushStraight;
    }

    public void setPushStraight(Integer pushStraight) {
        this.pushStraight = pushStraight;
    }

    public Integer getPushBetween() {
        return pushBetween;
    }

    public void setPushBetween(Integer pushBetween) {
        this.pushBetween = pushBetween;
    }

    public Integer getThreePush() {
        return threePush;
    }

    public void setThreePush(Integer threePush) {
        this.threePush = threePush;
    }

    public Recommend(Integer pushStraight, Integer pushBetween) {
        super();
        this.pushStraight = pushStraight;
        this.pushBetween = pushBetween;
    }

    public Recommend(Integer pushStraight, Integer pushBetween, Integer threePush) {
        super();
        this.pushStraight = pushStraight;
        this.pushBetween = pushBetween;
        this.threePush = threePush;
    }

    public Recommend(Integer pushStraight) {
        super();
        this.pushStraight = pushStraight;
    }

    public Recommend() {
        super();
        // TODO Auto-generated constructor stub
    }

}

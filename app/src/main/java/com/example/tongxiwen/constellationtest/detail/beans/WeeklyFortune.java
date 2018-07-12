package com.example.tongxiwen.constellationtest.detail.beans;

import com.alibaba.fastjson.annotation.JSONField;

public class WeeklyFortune {

    @JSONField(name = "name")
    private String name;
    @JSONField(name = "weekth")
    private String weekth;
    @JSONField(name = "month")
    private String month;
    @JSONField(name = "date")
    private String date;
    @JSONField(name = "health")
    private String health;
    @JSONField(name = "job")
    private String job;
    @JSONField(name = "love")
    private String love;
    @JSONField(name = "money")
    private String funding;
    @JSONField(name = "work")
    private String career;
    @JSONField(name = "all")
    private String fortune;
    @JSONField(name = "happymagic")
    private String happyMagic;
    @JSONField(name = "error_code")
    private String errorCode;
    @JSONField(name = "resultcode")
    private String resultcode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeekth() {
        return weekth;
    }

    public void setWeekth(String weekth) {
        this.weekth = weekth;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHealth() {
        return health;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getFunding() {
        return funding;
    }

    public void setFunding(String funding) {
        this.funding = funding;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getFortune() {
        return fortune;
    }

    public void setFortune(String fortune) {
        this.fortune = fortune;
    }

    public String getHappyMagic() {
        return happyMagic;
    }

    public void setHappyMagic(String happyMagic) {
        this.happyMagic = happyMagic;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }
}

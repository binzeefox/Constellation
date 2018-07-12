package com.example.tongxiwen.constellationtest.detail.beans;

import com.alibaba.fastjson.annotation.JSONField;

public class DailyFortune {

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "date")
    private String todayDate;

    @JSONField(name = "all")
    private String fortune;

    @JSONField(name = "color")
    private String luckyColor;

    @JSONField(name = "health")
    private String health;

    @JSONField(name = "love")
    private String love;

    @JSONField(name = "money")
    private String funding;

    @JSONField(name = "number")
    private String luckyNumber;

    @JSONField(name = "QFriend")
    private String coopConstellation;

    @JSONField(name = "summary")
    private String summary;

    @JSONField(name = "work")
    private String career;

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

    public String getTodayDate() {
        return todayDate;
    }

    public void setTodayDate(String todayDate) {
        this.todayDate = todayDate;
    }

    public String getFortune() {
        return fortune;
    }

    public void setFortune(String fortune) {
        this.fortune = fortune;
    }

    public String getLuckyColor() {
        return luckyColor;
    }

    public void setLuckyColor(String luckyColor) {
        this.luckyColor = luckyColor;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public String getFunding() {
        return funding;
    }

    public void setFunding(String funding) {
        this.funding = funding;
    }

    public String getLuckyNumber() {
        return luckyNumber;
    }

    public void setLuckyNumber(String luckyNumber) {
        this.luckyNumber = luckyNumber;
    }

    public String getCoopConstellation() {
        return coopConstellation;
    }

    public void setCoopConstellation(String coopConstellation) {
        this.coopConstellation = coopConstellation;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getcareer() {
        return career;
    }

    public void setcareer(String career) {
        this.career = career;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    @Override
    public String toString() {
        return "DailyFortune{" +
                "name='" + name + '\'' +
                ", todayDate='" + todayDate + '\'' +
                ", fortune='" + fortune + '\'' +
                ", luckyColor='" + luckyColor + '\'' +
                ", health='" + health + '\'' +
                ", love='" + love + '\'' +
                ", funding='" + funding + '\'' +
                ", luckyNumber='" + luckyNumber + '\'' +
                ", coopConstellation='" + coopConstellation + '\'' +
                ", summary='" + summary + '\'' +
                ", career='" + career + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", resultcode='" + resultcode + '\'' +
                '}';
    }
}


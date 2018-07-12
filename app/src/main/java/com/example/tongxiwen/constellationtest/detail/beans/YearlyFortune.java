package com.example.tongxiwen.constellationtest.detail.beans;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Map;

public class YearlyFortune {

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "date")
    private String date;

    @JSONField(name = "year")
    private String year;

    @JSONField(name = "mima")
    private Map<String, String> mima;
    private String info;
    private String text;

    @JSONField(name = "career")
    private String career;

    @JSONField(name = "love")
    private String love;

    @JSONField(name = "health")
    private String health;

    @JSONField(name = "finance")
    private String funding;

    @JSONField(name = "luckeystone")
    private String stone;

    @JSONField(name = "future")
    private String future;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Map<String, String> getMima() {
        return mima;
    }

    public void setMima(Map<String, String> mima) {
        this.mima = mima;
        this.info = mima.get("info");
        this.text = mima.get("text");
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getFunding() {
        return funding;
    }

    public void setFunding(String funding) {
        this.funding = funding;
    }

    public String getStone() {
        return stone;
    }

    public void setStone(String stone) {
        this.stone = stone;
    }

    public String getFuture() {
        return future;
    }

    public void setFuture(String future) {
        this.future = future;
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

    public String getInfo() {
        return info;
    }

    public String getText() {
        return text;
    }
}

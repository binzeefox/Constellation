package com.example.tongxiwen.constellationtest.util;

import com.example.tongxiwen.constellationtest.detail.beans.DailyFortune;
import com.example.tongxiwen.constellationtest.detail.beans.WeeklyFortune;
import com.example.tongxiwen.constellationtest.detail.beans.YearlyFortune;

import java.util.HashMap;
import java.util.Map;

public class FakeData {
    public static DailyFortune getDailyData() {
        DailyFortune data = new DailyFortune();
        data.setName("双鱼座");
        data.setTodayDate("20180530");
        data.setFortune("60%");
        data.setLove("80%");
        data.setcareer("60%");
        data.setFunding("60%");
        data.setHealth("75%");
        data.setLuckyColor("银色");
        data.setLuckyNumber("4");
        data.setCoopConstellation("巨蟹座");
        data.setSummary("有些琐碎的理不出头绪的工作需要你处理。正财运弱，工作进展的并不顺利，让你有些苦恼。不过从长久来看你仍然精力旺盛信心十足，这就行了。有伴的双鱼和另一半互动甜蜜，关系升温");
        return data;
    }

    public static WeeklyFortune getWeeklyData() {
        WeeklyFortune data = new WeeklyFortune();
        data.setName("双鱼座");
        data.setWeekth("22");
        data.setDate("2018年05月27日-2018年06月02日");
//        data.setHealth("我头疼，是真的头疼，偏头疼，淋巴结附近阵痛");
        data.setJob(null);
        data.setLove("恋爱：本周你的感情运比较一般，身边桃花较少，保持现状的可能性比较大。");
        data.setFunding("财运：本周如果你有关注的项目，可能会有让你选择的空间，自己做好判断，不要选择失误，导致破财。");
        data.setCareer("工作：本周工作状态相对来说比较轻松，愉快的工作状态让你在和团队合作中也能获得不错的成绩。");
        data.setResultcode("200");
        data.setErrorCode("0");
        return data;
    }

    public static WeeklyFortune getMonthlyData() {
        WeeklyFortune data = new WeeklyFortune();
        data.setName("双鱼座");
        data.setFortune("本月双鱼座终于有了目标，有了方向，各方面的表现都积极了起来。\r\n");
        data.setDate("2018年05月");
        data.setHealth("注意下控制脾气。\r\n");
        data.setLove("有伴的双鱼和另一半的相处过程中请注意控制自己的脾气，而单身的双鱼会有机会，自己也要行动起来啦。\r\n");
        data.setFunding("本月双鱼的财运还不错，特别是投资理财这块，会有回报。\r\n");
        data.setCareer("工作上会有重要的事情要去做，但是不一定特别顺利，会有阻碍。\r\n");
        data.setHappyMagic("");
        data.setResultcode("200");
        data.setErrorCode("0");
        return data;
    }

    public static YearlyFortune getYearlyData(){
        Map<String, String> mima = new HashMap<>();
        mima.put("info", "携手共进 事业冲顶");
        mima.put("text", "对大多数双鱼座而言，未来一年将是忙碌却充实，磕磕碰碰中触碰天际的一年。土星在双鱼座的事业宫已经停留了将近2年时间，也让双鱼们吃了不少苦头，原来很轻松的工作变得要求高高，或是被委以重任必须每一件事都全身心投入努力才可能看到成绩，但也是你们实现自我价值和社会地位的重要环节。尤其来到2017年，土天冲持续作用令事业宫与财帛宫联动，使得你们的付出很容易转换成物质回报。命主星木星在危机宫却为事业宫提供支持，很多双鱼座会担任起救火队长的工作，成为支援队伍中的中流砥柱，或是依靠自己良好的人脉为他人铺路，同时获得正反馈实现个人职位和价值的提升，并有望突破阶层的天花板，进入更加高大上的层次，实现自我价值的飞跃。");

        YearlyFortune data = new YearlyFortune();
        data.setName("双鱼座");
        data.setDate("2018年");
        data.setMima(mima);
        data.setCareer("土星离开双鱼座的事业宫，对于双鱼座而言是个好消息。在过去的两年多内，双鱼座在事业发展方面遭遇到了很多压力，很多双鱼座都处于止步不前的状态，或者遭遇到各种挑战，身心疲惫。有时候越努力越得不到他人的认同。进入2018年，双鱼座人逐渐走入了人们的视野。这个期间，双鱼座人会变得克己，会进件社交圈，会把心思放在进修和求知方面。利于外地事务，国际事务，传媒事务方面的发展。出国、再深造、提升专业能力等方面的事务，相对顺利。更多的时候，双鱼座人其实处在一种自我修正的状态，一直在寻找答案，对于过去的得失，会自我分析，力求找到突破口。2018年其实是双鱼座的整修年，通过这一年的学习思考，找出过去的症结，找到未来的方向。年初双鱼座容易有职场竞争意识，总是想要出头，却难免遭遇打压。也有人在年初选择离职换岗。年尾，双鱼座才真正具有职场竞争力，并且职场机遇来临，贵人也出现。所以，2019年值得期待，而在2018年，学习思考才是重点。");
        data.setLove("双鱼座人2018年到了年中的时候，才能提起兴致，放松心情拥抱爱情。不过，受到土星的压制，双鱼座人在2018年整体的人际交往，是内敛和克制的。自己是一种向内求的状态，与人交往多多少少都是有些防备。所以，整个年度的爱情体验，并不理想。双鱼座会被一些精神成长的事务所吸引，所以，作为双鱼座的伴侣，可以和他一起去探索哲学，宗教等方面的知识，共同成长，才有机会增进感情。某些双鱼座在2018年也容易陷入感情纠缠里，或者第三者事件中。我要提醒双鱼座，往往我们对某些理念产生认同感，就有可能深陷其中，会容易将不同观点者，变成对立面。学习到更多的知识，增长了见识，却变得更加执着和自我。双鱼座身上有着天生的善良和宽厚，但是如果被某些理念影响，就容易变成自以为是者，造成自己与他人的距离感，对你而言，就很难体验到爱的融合和浪漫啦。");
        data.setHealth("学习状态要好很多。如果你当前是学生党，那么2018对你而言是非常美好的一年。你会遇到你心底里认同的老师，深造和考试要顺利很多。心思也很容易专注在学业方面。健康问题要留意。由于日月蚀搅扰着你的健康宫，所以你的心脏，肠胃，免疫系统都需要注意，尤其年底，可能导致皮肤，头部等过敏受伤等状况发生。");
        data.setFunding("2017年10月份之前，双鱼座的外财运旺，10月10日木星转宫后，双鱼座的财运就没有那么好了。而且，伴随着天王星离开双鱼座的财帛宫，未来的双鱼座，暴富的机会少了很多。2018和2019年，相对来说双鱼座的财运没有什么特别大的起色，自己花钱要谨慎，挣钱要努力，贵人运减少，外财运也平淡。");
        data.setStone("青金石");
        return data;
    }
}

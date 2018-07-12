package com.example.tongxiwen.constellationtest.util;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FieldUtil {

    public static void setConstellationImage(ImageView view, String name){
        if (name == null)
            name = "";
        view.setImageResource(ConstellationUtil.getImageSrcByName(name));
    }

    public static void setFieldText(TextView view, String text){
        if (text == null) text = "";
        view.setText(text);
    }

    public static void setRatingField(RatingBar view, String score){
        if (score == null) score = "0";
        view.setRating(resolveToRate(score));
    }

    public static float resolveToRate(String scoreStr){
        scoreStr = scoreStr.replace("%","");
        float score = Float.parseFloat(scoreStr);
        return score/100*5;
    }

    /**
     *将字符串格式yyyyMMdd的字符串转为日期，格式"yyyy-MM-dd"
     *
     * @param date 日期字符串
     * @return 返回格式化的日期
     * @throws ParseException 分析时意外地出现了错误异常
     */
    public static String strToDateFormat(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        formatter.setLenient(false);
        Date newDate= null;
        try {
            newDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formatter = new SimpleDateFormat("MM/dd");
        return formatter.format(newDate);
    }
}

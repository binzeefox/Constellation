package com.example.tongxiwen.constellationtest.detail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.tongxiwen.constellationtest.R;
import com.example.tongxiwen.constellationtest.detail.beans.DailyFortune;
import com.example.tongxiwen.constellationtest.util.ConstellationUtil;
import com.example.tongxiwen.constellationtest.util.FieldUtil;

import java.lang.reflect.Field;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DailyDetailView extends FrameLayout {

    @BindView(R.id.image_icon)
    protected ImageView imageIconField;
    @BindView(R.id.type_field)
    protected TextView typeNameField;
    @BindView(R.id.date_region_field)
    protected TextView dateRegionField;
    @BindView(R.id.date_today)
    protected TextView dateTodayField;
    @BindView(R.id.rating_today_fortune)
    protected RatingBar todayFortuneField;
    @BindView(R.id.rating_love_fortune)
    protected RatingBar loveFortuneField;
    @BindView(R.id.rating_career_condition)
    protected RatingBar careerConditionField;
    @BindView(R.id.rating_funding_fortune)
    protected RatingBar fundingFortuneField;
    @BindView(R.id.rating_health_level)
    protected RatingBar healthLevelField;
    @BindView(R.id.lucky_color_field)
    protected TextView luckyColorField;
    @BindView(R.id.lucky_number_field)
    protected TextView luckyNumberField;
    @BindView(R.id.coop_constellation_field)
    protected TextView coopConstellationField;
    @BindView(R.id.fortune_summary_field)
    protected TextView summaryField;

    public DailyDetailView(@NonNull Context context) {
        this(context, null, 0);
    }
    public DailyDetailView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public DailyDetailView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        FrameLayout.LayoutParams params =
                new LayoutParams
                        (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        View detail = LayoutInflater.from(context).inflate(R.layout.detail_view, null);
        addView(detail, params);

        ButterKnife.bind(this);
    }

    public void setData(DailyFortune data){
        if (data == null) return;
        String name = data.getName();
        FieldUtil.setConstellationImage(imageIconField, name);
        FieldUtil.setFieldText(typeNameField, name);
        FieldUtil.setFieldText(dateRegionField, ConstellationUtil.getDateRegionByName(name));
        FieldUtil.setFieldText(dateTodayField, FieldUtil.strToDateFormat(data.getTodayDate()));
        FieldUtil.setRatingField(todayFortuneField, data.getFortune());
        FieldUtil.setRatingField(loveFortuneField, data.getLove());
        FieldUtil.setRatingField(careerConditionField, data.getcareer());
        FieldUtil.setRatingField(fundingFortuneField, data.getFunding());
        FieldUtil.setRatingField(healthLevelField, data.getHealth());
        FieldUtil.setFieldText(luckyColorField, data.getLuckyColor());
        FieldUtil.setFieldText(luckyNumberField, data.getLuckyNumber());
        FieldUtil.setFieldText(coopConstellationField, data.getCoopConstellation());
        FieldUtil.setFieldText(summaryField, data.getSummary());
    }
}

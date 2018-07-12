package com.example.tongxiwen.constellationtest.detail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tongxiwen.constellationtest.R;
import com.example.tongxiwen.constellationtest.detail.beans.WeeklyFortune;
import com.example.tongxiwen.constellationtest.util.ConstellationUtil;
import com.example.tongxiwen.constellationtest.util.FieldUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeeklyDetailView extends FrameLayout {

    @BindView(R.id.image_icon)
    protected ImageView imageIconField;
    @BindView(R.id.type_field)
    protected TextView typeNameField;
    @BindView(R.id.weekth_field)
    protected TextView weekthField;
    @BindView(R.id.date_region_field)
    protected TextView dateRegionField;
    @BindView(R.id.date_field)
    protected TextView dateField;
    @BindView(R.id.monthly_all_field)
    protected TextView monthlyAllField;
    @BindView(R.id.health_recommend_field)
    protected TextView healthField;
    @BindView(R.id.job_field)
    protected TextView jobField;
    @BindView(R.id.love_field)
    protected TextView loveField;
    @BindView(R.id.funding_field)
    protected TextView fundingField;
    @BindView(R.id.career_field)
    protected TextView careerField;
    @BindView(R.id.happy_magic_field)
    protected TextView happyMagicField;

    @BindView(R.id.all_row)
    protected View allRow;
    @BindView(R.id.career_row)
    protected View careerRow;
    @BindView(R.id.funding_row)
    protected View fundingRow;
    @BindView(R.id.health_recommend_row)
    protected View healthRow;
    @BindView(R.id.job_row)
    protected View jobRow;
    @BindView(R.id.love_row)
    protected View loveRow;
    @BindView(R.id.happy_magic_row)
    protected View magicRow;


    public WeeklyDetailView(@NonNull Context context) {
        this(context, null ,0);
    }
    public WeeklyDetailView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public WeeklyDetailView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        FrameLayout.LayoutParams params =
                new LayoutParams
                        (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        View detail = LayoutInflater.from(context).inflate(R.layout.weekly_detail, null);
        addView(detail, params);

        ButterKnife.bind(this);
    }

    public void setData(WeeklyFortune data){
        if (data == null) return;
        String name = data.getName();
        FieldUtil.setConstellationImage(imageIconField, name);
        FieldUtil.setFieldText(typeNameField, name);
        FieldUtil.setFieldText(dateRegionField, ConstellationUtil.getDateRegionByName(name));
        FieldUtil.setFieldText(dateField, data.getDate());
        FieldUtil.setFieldText(weekthField, "第" + data.getWeekth() + "周");
        weekthField.setVisibility(TextUtils.isEmpty(data.getWeekth()) ? GONE : VISIBLE);

        String str = null;

        str = data.getFortune();
        allRow.setVisibility(TextUtils.isEmpty(str) ? GONE : VISIBLE);
        monthlyAllField.setText(str);

        str = data.getHealth();
        healthRow.setVisibility(TextUtils.isEmpty(str) ? GONE : VISIBLE);
        healthField.setText(str);

        str = data.getJob();
        jobRow.setVisibility(TextUtils.isEmpty(str) ? GONE : VISIBLE);
        jobField.setText(str);

        str = data.getLove();
        loveRow.setVisibility(TextUtils.isEmpty(str) ? GONE : VISIBLE);
        loveField.setText(str);

        str = data.getFunding();
        fundingRow.setVisibility(TextUtils.isEmpty(str) ? GONE : VISIBLE);
        fundingField.setText(str);

        str = data.getCareer();
        careerRow.setVisibility(TextUtils.isEmpty(str) ? GONE : VISIBLE);
        careerField.setText(str);

        str = data.getHappyMagic();
        magicRow.setVisibility(TextUtils.isEmpty(str) ? GONE : VISIBLE);
        happyMagicField.setText(str);
    }
}

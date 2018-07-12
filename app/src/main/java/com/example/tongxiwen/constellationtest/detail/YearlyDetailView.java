package com.example.tongxiwen.constellationtest.detail;

import android.content.Context;
import android.graphics.Paint;
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
import com.example.tongxiwen.constellationtest.detail.beans.YearlyFortune;
import com.example.tongxiwen.constellationtest.util.ConstellationUtil;
import com.example.tongxiwen.constellationtest.util.FieldUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class YearlyDetailView extends FrameLayout {

    @BindView(R.id.image_icon)
    protected ImageView imageIconField;
    @BindView(R.id.type_field)
    protected TextView typeNameField;
    @BindView(R.id.date_region_field)
    protected TextView dateRegionField;
    @BindView(R.id.date_field)
    protected TextView dateField;
    @BindView(R.id.stone_field)
    protected TextView stoneField;
    @BindView(R.id.mima_info_field)
    protected TextView mimaInfoField;
    @BindView(R.id.mima_text_field)
    protected TextView mimaTextField;
    @BindView(R.id.career_field)
    protected TextView careerField;
    @BindView(R.id.love_field)
    protected TextView loveField;
    @BindView(R.id.health_field)
    protected TextView healthField;
    @BindView(R.id.funding_field)
    protected TextView fundingField;

    @BindView(R.id.stone_row)
    protected View stoneRow;
    @BindView(R.id.mima_row)
    protected View mimaRow;
    @BindView(R.id.career_row)
    protected View careerRow;
    @BindView(R.id.love_row)
    protected View loveRow;
    @BindView(R.id.health_row)
    protected View healthRow;
    @BindView(R.id.funding_row)
    protected View fundingRow;


    public YearlyDetailView(@NonNull Context context) {
        this(context, null, 0);
    }
    public YearlyDetailView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public YearlyDetailView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        FrameLayout.LayoutParams params =
                new LayoutParams
                        (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        View detail = LayoutInflater.from(context).inflate(R.layout.yearly_detail, null);
        addView(detail, params);

        ButterKnife.bind(this);
    }

    public void setData(YearlyFortune data){
        if (data == null) return;
        String name = data.getName();
        FieldUtil.setConstellationImage(imageIconField, name);
        FieldUtil.setFieldText(typeNameField, name);
        FieldUtil.setFieldText(dateRegionField, ConstellationUtil.getDateRegionByName(name));
        FieldUtil.setFieldText(dateField, data.getDate());

        String str = null;

        boolean isMima = data.getMima() != null;
        mimaRow.setVisibility(isMima ? VISIBLE : GONE);
        if (isMima){
            FieldUtil.setFieldText(mimaInfoField, data.getInfo());
            FieldUtil.setFieldText(mimaTextField, data.getText());
        }

        str = data.getHealth();
        healthRow.setVisibility(TextUtils.isEmpty(str) ? GONE : VISIBLE);
        healthField.setText(str);

        str = data.getCareer();
        careerRow.setVisibility(TextUtils.isEmpty(str) ? GONE : VISIBLE);
        careerField.setText(str);

        str = data.getLove();
        loveRow.setVisibility(TextUtils.isEmpty(str) ? GONE : VISIBLE);
        loveField.setText(str);

        str = data.getFunding();
        healthRow.setVisibility(TextUtils.isEmpty(str) ? GONE : VISIBLE);
        healthField.setText(str);

        str = data.getCareer();
        fundingRow.setVisibility(TextUtils.isEmpty(str) ? GONE : VISIBLE);
        fundingField.setText(str);

        str = data.getStone();
        stoneRow.setVisibility(TextUtils.isEmpty(str) ? GONE : VISIBLE);
        stoneField.setText(str);
    }
}

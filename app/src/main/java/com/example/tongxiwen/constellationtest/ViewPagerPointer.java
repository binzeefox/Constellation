package com.example.tongxiwen.constellationtest;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.tongxiwen.constellationtest.util.DimenUtil;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerPointer extends RadioGroup{

    private boolean clickable = true;  // 是否可点击
    private int maxItem;    // 最大item数
    private boolean isInfinal = false;  // 是否为添加首尾方法的无限轮播图
    private ViewPager mViewPager;    // 目标ViewPager
    private List<RadioButton> mButtonList;

    public ViewPagerPointer(Context context) {
        this(context, null);
    }
    public ViewPagerPointer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setUpViewPager(ViewPager viewPager) throws IllegalAccessException {
        setUpViewPager(viewPager, false);
    }
    public void setUpViewPager(ViewPager viewPager, boolean isInfinal) throws IllegalAccessException{
        mViewPager = viewPager;
        this.isInfinal = isInfinal;
        if (viewPager.getAdapter() == null)
            throw new IllegalAccessException("ViewPager必须先设置Adapter");
        maxItem = mViewPager.getAdapter().getCount();
        if (isInfinal)
            maxItem -= 2;

        mButtonList = new ArrayList<>();
        RadioButton rbt;
        RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        if (getOrientation() == HORIZONTAL) {
            params.leftMargin = DimenUtil.dip2px(4);
            params.rightMargin = DimenUtil.dip2px(4);
        } else if (getOrientation() == VERTICAL){
            params.topMargin = DimenUtil.dip2px(4);
            params.bottomMargin = DimenUtil.dip2px(4);
        }

        for (int i = 0; i < maxItem; i++){
            rbt = new RadioButton(getContext());
            rbt.setLayoutParams(params);
            rbt.setButtonDrawable(R.drawable.view_pager_pointer);
            addView(rbt);
            mButtonList.add(rbt);
        }
        setCurrent(isInfinal ? 1 : 0);
    }

    public void setCurrent(int position){
        if (isInfinal)
            position -= 1;
        if (position < 0)
            position = maxItem - 1;
        else if (position >= maxItem){
            position = 0;
        }
        mButtonList.get(position).setChecked(true);
    }

    public void setClickable(boolean clickable){
        this.clickable = clickable;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return clickable;
    }
}

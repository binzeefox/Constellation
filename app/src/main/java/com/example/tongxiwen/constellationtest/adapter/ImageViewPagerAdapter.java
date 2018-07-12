package com.example.tongxiwen.constellationtest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ImageViewPagerAdapter extends PagerAdapter {
    private List<ImageView> imgViews;
    private Context mContext;
    private int[] srcs;
    private List<Integer> data;

    public ImageViewPagerAdapter(Context context, int[] srcs){
        mContext = context;
        imgViews = new ArrayList<>();
        this.srcs = srcs;
        data = new ArrayList<>();
        convertViews(srcs);
    }

    private void convertViews(int[] srcs) {
        data.add(srcs[srcs.length - 1]);
        for (int idx : srcs){
            data.add(idx);
        }
        data.add(srcs[0]);

        for (int idx : data){
            ImageView view = new ImageView(mContext);
            view.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgViews.add(view);
        }
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView view = imgViews.get(position);
        container.addView(view);
        Glide.with(mContext).load(data.get(position)).into(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(imgViews.get(position));
    }
}

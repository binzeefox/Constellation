package com.example.tongxiwen.constellationtest.adapter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.example.tongxiwen.constellationtest.R;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<SparseArray> mFragmentList;

    public ViewPagerAdapter(FragmentManager fm, List<SparseArray> fragments) {
        super(fm);
        this.mFragmentList = fragments;
    }

    public void setFragments(List<SparseArray> fragments) {
        mFragmentList = fragments;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return (Fragment) mFragmentList.get(position).get(R.id.fragments_instance);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public String getTabTitle(int position){
        return (String) mFragmentList.get(position).get(R.id.fragments_tab);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }
}

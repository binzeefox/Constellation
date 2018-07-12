package com.example.tongxiwen.constellationtest.mvp.weekly;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tongxiwen.constellationtest.R;
import com.example.tongxiwen.constellationtest.detail.WeeklyDetailView;
import com.example.tongxiwen.constellationtest.detail.beans.DailyFortune;
import com.example.tongxiwen.constellationtest.detail.beans.WeeklyFortune;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailWeeklyFragment extends Fragment implements IWeeklyDetailContract.View{

    @BindView(R.id.display)
    WeeklyDetailView detailView;
    private IWeeklyDetailContract.Presenter mPresenter;
    private String mConsName;
    private String mType;

    public static DetailWeeklyFragment newInstance(String consName, String type) {
        Bundle args = new Bundle();
        args.putString("consName", consName);
        args.putString("type", type);

        DetailWeeklyFragment fragment = new DetailWeeklyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail_weekly, container, false);
        ButterKnife.bind(this, v);
        if (getArguments() != null) {
            mConsName = getArguments().getString("consName");
            mType = getArguments().getString("type");
        }
        mPresenter = new Presenter(this);
        mPresenter.askForData(mConsName, mType);

        return v;
    }

    @Override
    public void showInfo(WeeklyFortune data) {
        if ("200".equals(data.getResultcode()))
            detailView.setData(data);
    }
}

package com.example.tongxiwen.constellationtest.mvp.daily;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tongxiwen.constellationtest.R;
import com.example.tongxiwen.constellationtest.detail.DailyDetailView;
import com.example.tongxiwen.constellationtest.detail.beans.DailyFortune;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailDailyFragment extends Fragment implements IDailyDetailContract.View {

    @BindView(R.id.display)
    DailyDetailView detailView;

    private String mConsName;

    private IDailyDetailContract.Presenter mPresenter;

    public static DetailDailyFragment newInstance(String consName) {
        Bundle args = new Bundle();
        args.putString("consName", consName);

        DetailDailyFragment fragment = new DetailDailyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_daily_detail, container, false);
        ButterKnife.bind(this, v);
        if (getArguments() != null) {
            mConsName = getArguments().getString("consName");
        }

        mPresenter = new Presenter(this);
        mPresenter.askForData(mConsName, "today");
        return v;
    }

    @Override
    public void showInfo(DailyFortune data) {
        if ("200".equals(data.getResultcode()))
            detailView.setData(data);
    }
}

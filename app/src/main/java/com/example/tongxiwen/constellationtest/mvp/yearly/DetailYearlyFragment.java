package com.example.tongxiwen.constellationtest.mvp.yearly;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tongxiwen.constellationtest.R;
import com.example.tongxiwen.constellationtest.detail.YearlyDetailView;
import com.example.tongxiwen.constellationtest.detail.beans.YearlyFortune;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailYearlyFragment extends Fragment implements IYearlyDetailContract.View{

    @BindView(R.id.display)
    YearlyDetailView detailView;
    private IYearlyDetailContract.Presenter mPresenter;

    private String mConsName;

    public static DetailYearlyFragment newInstance(String consName) {
        Bundle args = new Bundle();
        args.putString("consName", consName);

        DetailYearlyFragment fragment = new DetailYearlyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail_yearly, container, false);
        ButterKnife.bind(this, v);
        if (getArguments() != null) {
            mConsName = getArguments().getString("consName");
        }

        mPresenter = new Presenter(this);
        mPresenter.askForData(mConsName, "year");

        return v;
    }

    @Override
    public void showInfo(YearlyFortune data) {
        if ("200".equals(data.getResultcode()))
            detailView.setData(data);
    }
}

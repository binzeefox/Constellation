package com.example.tongxiwen.constellationtest.mvp.yearly;

import com.example.tongxiwen.constellationtest.detail.beans.WeeklyFortune;
import com.example.tongxiwen.constellationtest.detail.beans.YearlyFortune;

import io.reactivex.Observable;

public interface IYearlyDetailContract {
    interface View{
        void showInfo(YearlyFortune data);
    }

    interface Presenter{
        void bindView(View view);
        void askForData(String consName, String type);
    }

    interface Model{
        Observable<YearlyFortune> getYearlyFortune(String consName, String type);
    }
}

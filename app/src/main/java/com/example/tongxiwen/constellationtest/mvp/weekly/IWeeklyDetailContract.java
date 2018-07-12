package com.example.tongxiwen.constellationtest.mvp.weekly;

import com.example.tongxiwen.constellationtest.detail.beans.DailyFortune;
import com.example.tongxiwen.constellationtest.detail.beans.WeeklyFortune;

import io.reactivex.Observable;

public interface IWeeklyDetailContract {
    interface View{
        void showInfo(WeeklyFortune data);
    }

    interface Presenter{
        void bindView(View view);
        void askForData(String consName, String type);
    }

    interface Model{
        Observable<WeeklyFortune> getDailyFortune(String consName, String type);
    }
}

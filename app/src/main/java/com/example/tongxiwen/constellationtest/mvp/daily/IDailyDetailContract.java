package com.example.tongxiwen.constellationtest.mvp.daily;

import com.example.tongxiwen.constellationtest.detail.beans.DailyFortune;


import io.reactivex.Observable;

public interface IDailyDetailContract {
    interface View{
        void showInfo(DailyFortune data);
    }

    interface Presenter{
        void bindView(View view);
        void askForData(String consName, String type);
    }

    interface Model{
        Observable<DailyFortune> getDailyFortune(String consName, String type);
    }
}

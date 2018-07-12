package com.example.tongxiwen.constellationtest.mvp.weekly;

import com.example.tongxiwen.constellationtest.detail.beans.WeeklyFortune;
import com.example.tongxiwen.constellationtest.net.HttpClient;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Presenter implements IWeeklyDetailContract.Presenter {

    private IWeeklyDetailContract.View view;
    private IWeeklyDetailContract.Model model;

    public Presenter(IWeeklyDetailContract.View view){
        bindView(view);
        model = new Model();
    }

    @Override
    public void bindView(IWeeklyDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void askForData(String consName, String type) {
        model.getDailyFortune(consName, type)
                .subscribe(new Observer<WeeklyFortune>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        //TODO 加载状态
                    }

                    @Override
                    public void onNext(WeeklyFortune weeklyFortune) {
                        view.showInfo(weeklyFortune);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        //TODO 加载结束
                    }
                });
    }
}

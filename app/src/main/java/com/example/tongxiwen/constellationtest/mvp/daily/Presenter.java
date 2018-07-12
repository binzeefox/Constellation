package com.example.tongxiwen.constellationtest.mvp.daily;

import com.example.tongxiwen.constellationtest.detail.beans.DailyFortune;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Presenter implements IDailyDetailContract.Presenter {

    private IDailyDetailContract.View view;
    private IDailyDetailContract.Model model;


    public Presenter(IDailyDetailContract.View view){
        bindView(view);
        model = new Model();
    }

    @Override
    public void bindView(IDailyDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void askForData(String consName, String type) {
        model.getDailyFortune(consName, type)
                .subscribe(new Observer<DailyFortune>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DailyFortune dailyFortune) {
                        view.showInfo(dailyFortune);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

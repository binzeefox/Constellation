package com.example.tongxiwen.constellationtest.mvp.yearly;

import com.example.tongxiwen.constellationtest.detail.beans.YearlyFortune;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Presenter implements IYearlyDetailContract.Presenter {
    private IYearlyDetailContract.View view;
    private IYearlyDetailContract.Model model;

    public Presenter(IYearlyDetailContract.View view){
        bindView(view);
        model = new Model();
    }

    @Override
    public void bindView(IYearlyDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void askForData(String consName, String type) {
        model.getYearlyFortune(consName, type)
                .subscribe(new Observer<YearlyFortune>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(YearlyFortune yearlyFortune) {
                        view.showInfo(yearlyFortune);
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

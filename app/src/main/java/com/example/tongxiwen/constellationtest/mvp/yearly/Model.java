package com.example.tongxiwen.constellationtest.mvp.yearly;

import com.example.tongxiwen.constellationtest.detail.beans.YearlyFortune;
import com.example.tongxiwen.constellationtest.net.HttpClient;

import java.util.Map;

import io.reactivex.Observable;

public class Model implements IYearlyDetailContract.Model {
    private HttpClient mClient;

    public Model(){
        mClient = HttpClient.newInstance();
    }

    @Override
    public Observable<YearlyFortune> getYearlyFortune(String consName, String type) {
        Map<String, String> params = HttpClient.getDefultParams();
        params.put("consName", consName);
        params.put("type", type);

        return mClient.getApi()
                .getYearlyFortune(params)
                .compose(HttpClient.<YearlyFortune>setThread());
    }
}

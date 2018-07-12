package com.example.tongxiwen.constellationtest.mvp.daily;

import com.example.tongxiwen.constellationtest.detail.beans.DailyFortune;
import com.example.tongxiwen.constellationtest.net.HttpClient;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

public class Model implements IDailyDetailContract.Model {

    private HttpClient client;

    public Model(){
        client = HttpClient.newInstance();
    }

    @Override
    public Observable<DailyFortune> getDailyFortune(String consName, String type) {
        Map<String, String> params = HttpClient.getDefultParams();
        params.put("consName", consName);
        params.put("type", type);
        return client
                .getApi()
                .getDailyFortune(params)
                .compose(HttpClient.<DailyFortune>setThread());
    }
}

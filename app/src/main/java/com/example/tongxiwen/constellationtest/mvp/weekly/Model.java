package com.example.tongxiwen.constellationtest.mvp.weekly;

import com.example.tongxiwen.constellationtest.detail.beans.WeeklyFortune;
import com.example.tongxiwen.constellationtest.net.HttpClient;

import java.util.Map;

import io.reactivex.Observable;

public class Model implements IWeeklyDetailContract.Model {

    private HttpClient client;

    public Model(){
        client = HttpClient.newInstance();
    }

    @Override
    public Observable<WeeklyFortune> getDailyFortune(String consName, String type) {
        Map<String, String> params = HttpClient.getDefultParams();
        params.put("consName", consName);
        params.put("type", type);

        return client.getApi()
                .getWeeklyFortune(params)
                .compose(HttpClient.<WeeklyFortune>setThread());
    }
}

package com.example.tongxiwen.constellationtest.net;

import com.example.tongxiwen.constellationtest.detail.beans.DailyFortune;
import com.example.tongxiwen.constellationtest.detail.beans.WeeklyFortune;
import com.example.tongxiwen.constellationtest.detail.beans.YearlyFortune;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface Api {

    @GET("getAll")
    Observable<DailyFortune> getDailyFortune(@QueryMap Map<String, String> map);

    @GET("getAll")
    Observable<WeeklyFortune> getWeeklyFortune(@QueryMap Map<String, String> map);

    @GET("getAll")
    Observable<YearlyFortune> getYearlyFortune(@QueryMap Map<String, String> map);
}

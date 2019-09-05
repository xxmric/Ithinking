package com.example.ithinking.api.service;

import com.example.ithinking.bean.BookBean;
import com.example.ithinking.bean.WeatherBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2018/5/10.
 */

public interface RetrofitService {
    /*
    * https://www.sojson.com/open/api/weather/json.shtml?city=广州
    * */
    @GET("open/api/weather/json.shtml")
    Observable<WeatherBean> getWeather(@Query("city") String city);

    /*
    * https://api.douban.com/v2/book/search?q=金瓶梅
    * */
    @GET("book/search")
    Observable<BookBean> getBook(@Query("q") String name);

}
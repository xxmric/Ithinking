package com.example.ithinking.api.service;

import com.example.ithinking.bean.BookBean;
import com.example.ithinking.bean.WeatherBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2018/5/10.
 */

public interface RetrofitService {
    /*
    * http://www.weather.com.cn/data/sk/101010100.html
    * */
    @GET("data/sk/{city}.html")
    Observable<WeatherBean> getWeather(@Path("city") String city);

    /*
    * https://api.douban.com/v2/book/search?q=金瓶梅
    * */
    @GET("book/search")
    Observable<BookBean> getBook(@Query("q") String name);


}
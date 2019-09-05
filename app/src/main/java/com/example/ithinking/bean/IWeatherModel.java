package com.example.ithinking.bean;

/**
 * Created by Administrator on 2018/5/8.
 */

public interface IWeatherModel {
    void loadWeather(String city, ILoadListener loadListener);

}

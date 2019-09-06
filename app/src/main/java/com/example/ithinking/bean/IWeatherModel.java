package com.example.ithinking.bean;

/**
 * 请求加载数据模型接口
 * Created by Administrator on 2018/5/8.
 */

public interface IWeatherModel {
    void loadWeather(String city, ILoadListener loadListener);

}

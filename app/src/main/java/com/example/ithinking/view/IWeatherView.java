package com.example.ithinking.view;


import com.example.ithinking.bean.WeatherBean;

/**
 * Created by Administrator on 2018/5/12.
 */

public interface IWeatherView {
    void showProgress();
    void hideProgress();
    void showWeatherData(WeatherBean weatherBean);
    void showLoadFailMsg(Throwable t);
}

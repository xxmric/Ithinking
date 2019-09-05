package com.example.ithinking.bean;


/**
 * Created by Administrator on 2018/5/8.
 */

public interface ILoadListener {
    void onSuccess(WeatherBean bean);

    void onFailure(Throwable t);
}

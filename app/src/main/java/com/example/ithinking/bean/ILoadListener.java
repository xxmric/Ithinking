package com.example.ithinking.bean;


/**
 * 请求数据加载监听器
 * Created by Administrator on 2018/5/8.
 */

public interface ILoadListener {
    void onSuccess(WeatherBean bean);

    void onFailure(Throwable t);
}

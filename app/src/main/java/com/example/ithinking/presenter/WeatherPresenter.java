package com.example.ithinking.presenter;


import com.example.ithinking.bean.ILoadListener;
import com.example.ithinking.bean.IWeatherModel;
import com.example.ithinking.bean.WeatherBean;
import com.example.ithinking.bean.WeatherModel;
import com.example.ithinking.view.IWeatherView;

/**
 * Created by Administrator on 2018/5/12.
 */

public class WeatherPresenter implements IWeatherPresenter, ILoadListener {

    private String url = "https://www.sojson.com/open/api/weather/json.shtml?city=";

    private IWeatherView iWeatherView;
    private IWeatherModel iWeatherModel;

    public WeatherPresenter(IWeatherView iWeatherView) {
        this.iWeatherView = iWeatherView;
        this.iWeatherModel=new WeatherModel();
    }

    @Override
    public void loadWeather(String city) {
        iWeatherView.showProgress();
        iWeatherModel.loadWeather(city,this);
    }

    @Override
    public void onSuccess(WeatherBean bean) {//数据回调
        iWeatherView.hideProgress();
        iWeatherView.showWeatherData(bean);
    }

    @Override
    public void onFailure(Throwable t) {
        iWeatherView.hideProgress();
        iWeatherView.showLoadFailMsg(t);
    }
}

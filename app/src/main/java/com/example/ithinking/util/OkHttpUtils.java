package com.example.ithinking.util;

import android.util.Log;


import com.example.ithinking.bean.BookBean;
import com.example.ithinking.bean.WeatherBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/5/2.
 */

public class OkHttpUtils {
    String res = null;
    private static OkHttpUtils okHttpUtils;


    private synchronized static OkHttpUtils getInstance() {
        if (okHttpUtils == null) {
            okHttpUtils = new OkHttpUtils();
        }
        return okHttpUtils;
    }

    public static void getResultCallback(String url, ResultCallback resultCallback) {
        getInstance().sendRequest(url, resultCallback);
    }
    public static void getResultBookCallback(String url, ResultBookCallback resultBookCallback) {
        getInstance().sendBookRequest(url, resultBookCallback);
    }


    public void sendRequest(String url, final ResultCallback resultCallback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(2, TimeUnit.SECONDS)
                .build();

        final Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (resultCallback != null) {
                    resultCallback.onFailure(e);
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                res = response.body().string();
                Log.i("res", res);
//                WeatherBean bean = JsonUtils.getWeather(res);
                Type type = new TypeToken<WeatherBean>() {}.getType();
                WeatherBean bean = new Gson().fromJson(res, type);
                if (resultCallback != null) {
                    resultCallback.getWeather(bean);
                }
            }
        });
    }
    public void sendBookRequest(String url, final ResultBookCallback resultBookCallback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(2, TimeUnit.SECONDS)
                .build();

        final Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (resultBookCallback != null) {
                    resultBookCallback.onFailure(e);
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                res = response.body().string();
                Log.i("res", res);
                Type type = new TypeToken<BookBean>() {}.getType();
                BookBean bean = new Gson().fromJson(res, type);
                if (resultBookCallback != null) {
                    resultBookCallback.getBook(bean);
                }
            }
        });
    }

    public interface ResultCallback {
        void getWeather(WeatherBean weatherBean);

        void onFailure(Exception e);
    }
    public interface ResultBookCallback {
        void getBook(BookBean bookBean);

        void onFailure(Exception e);
    }
}

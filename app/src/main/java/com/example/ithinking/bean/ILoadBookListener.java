package com.example.ithinking.bean;


/**
 * Created by Administrator on 2018/5/15.
 */

public interface ILoadBookListener {
    void onSuccess(BookBean bookBean);

    void onFailure(Throwable t);
}

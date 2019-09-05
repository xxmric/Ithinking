package com.example.ithinking.bean;

/**
 * Created by Administrator on 2018/5/15.
 */

public interface IBookModel {
    void loadBook(String name, ILoadBookListener iLoadBookListener);
}

package com.example.ithinking.view;


import com.example.ithinking.bean.BookBean;

/**
 * Created by Administrator on 2018/5/15.
 */

public interface IBookView {
    void showBook(BookBean bookBean);

    void showProgress();

    void hideProgress();

    void showLoadFailMsg(Throwable t);

}

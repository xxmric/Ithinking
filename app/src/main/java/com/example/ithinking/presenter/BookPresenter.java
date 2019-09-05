package com.example.ithinking.presenter;


import com.example.ithinking.bean.BookBean;
import com.example.ithinking.bean.BookModel;
import com.example.ithinking.bean.IBookModel;
import com.example.ithinking.bean.ILoadBookListener;
import com.example.ithinking.view.IBookView;

/**
 * Created by Administrator on 2018/5/15.
 */

public class BookPresenter implements ILoadBookListener,IBookPresenter{

    private String url="https://api.douban.com/v2/book/search?q=";

    private IBookView iBookView;
    private IBookModel iBookModel;

    public BookPresenter(IBookView iBookView) {
        this.iBookModel=new BookModel();
        this.iBookView=iBookView;
    }

    @Override
    public void onSuccess(BookBean bookBean) {
        iBookView.hideProgress();
        iBookView.showBook(bookBean);
    }

    @Override
    public void onFailure(Throwable t) {
        iBookView.hideProgress();
        iBookView.showLoadFailMsg(t);
    }



    @Override
    public void loadBook(String bookName) {
        iBookView.showProgress();
        iBookModel.loadBook(bookName,this);
    }
}

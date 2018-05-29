package com.example.asus.yklx.ui.base;

/**
 * Created by asus on 2018/5/28.
 */

public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {
    protected T mView;
    @Override
    public void attchView(T view) {
//        if (mView!=null) {
            this.mView = view;
//        }
    }

    @Override
    public void detachView() {
        if (mView!=null) {
            this.mView = null;
        }
    }
}

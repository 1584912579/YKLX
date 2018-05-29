package com.example.asus.yklx.ui.list.presenter;

import com.example.asus.yklx.bean.MobileBean;
import com.example.asus.yklx.net.MobileApi;
import com.example.asus.yklx.ui.base.BasePresenter;
import com.example.asus.yklx.ui.list.contract.MobileContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asus on 2018/5/28.
 */

public class MobilePresenter extends BasePresenter<MobileContract.View> implements MobileContract.Presenter {
    private MobileApi mobileApi;
    @Inject
    public MobilePresenter(MobileApi mobileApi) {
        this.mobileApi = mobileApi;
    }

    @Override
    public void Mobile(String key, String num,String page) {
        mobileApi.getMobileApi(key,num,page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MobileBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MobileBean mobileBean) {
                        if (mView!=null){
                            mView.MobileSuccess(mobileBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

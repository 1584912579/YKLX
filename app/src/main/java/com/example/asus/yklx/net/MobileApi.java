package com.example.asus.yklx.net;

import com.example.asus.yklx.bean.MobileBean;

import io.reactivex.Observable;

/**
 * Created by asus on 2018/5/28.
 */

public class MobileApi {
    private static MobileApi mobileApi;
    private MobileApiService mobileApiService;

    private MobileApi (MobileApiService mobileApiService){
        this.mobileApiService=mobileApiService;
    }
    public static MobileApi getMobileApi(MobileApiService mobileApiService){
        if (mobileApi==null){
            mobileApi=new MobileApi(mobileApiService);
        }
        return mobileApi;
    }
    public Observable<MobileBean> getMobileApi(String key,String num,String page){
        return mobileApiService.getMobileApi(key,num,page);
    }
}

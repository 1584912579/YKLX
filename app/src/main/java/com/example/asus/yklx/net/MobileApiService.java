package com.example.asus.yklx.net;

import com.example.asus.yklx.bean.MobileBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by asus on 2018/5/28.
 */

public interface MobileApiService {
   // @FormUrlEncoded
    @GET("mobile/")
    Observable<MobileBean> getMobileApi(@Query("key") String key, @Query("num") String num,@Query("page") String page);
}

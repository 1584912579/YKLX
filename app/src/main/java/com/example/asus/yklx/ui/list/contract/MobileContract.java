package com.example.asus.yklx.ui.list.contract;

import com.example.asus.yklx.bean.MobileBean;
import com.example.asus.yklx.ui.base.BaseContract;

/**
 * Created by asus on 2018/5/28.
 */

public interface MobileContract {
    interface View extends BaseContract.BaseView {
        void MobileSuccess(MobileBean mobileBean);
    }
    interface Presenter extends BaseContract.BasePresenter<View> {
        void Mobile(String key, String num,String page);
    }
}

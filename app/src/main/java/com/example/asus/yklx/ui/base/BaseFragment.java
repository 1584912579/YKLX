package com.example.asus.yklx.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import com.example.asus.yklx.inter.IBse;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by asus on 2018/5/28.
 */

public abstract class BaseFragment<T extends BaseContract.BasePresenter> extends Fragment implements IBse,BaseContract.BaseView {
    @Inject
    protected T mPresenter;
    private Unbinder bind;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
        if (mPresenter!=null){
            mPresenter.attchView(this);
        }
        if (bind != null) {
            bind.unbind();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getContentLayout(), null, false);
        initView(view);
        bind = ButterKnife.bind(getActivity(), view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter=null;
        }
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }
}

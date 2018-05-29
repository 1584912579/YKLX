package com.example.asus.yklx.ui.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.yklx.R;
import com.example.asus.yklx.bean.MobileBean;
import com.example.asus.yklx.component.DaggerHttpComponent;
import com.example.asus.yklx.module.HttpModule;
import com.example.asus.yklx.ui.base.BaseFragment;
import com.example.asus.yklx.ui.list.contract.MobileContract;
import com.example.asus.yklx.ui.list.presenter.MobilePresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import dagger.internal.DaggerCollections;

/**
 * Created by asus on 2018/5/28.
 */

public class Fragment1 extends BaseFragment<MobilePresenter> implements MobileContract.View {
    private View view;
    private XRecyclerView mXrv;
    private XRVAdapter xrvAdapter;
    private int  page=1;
    private boolean  flag=true;
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.frag1, container, false);
//
//
//        return view;
//    }

    @Override
    public int getContentLayout() {
        return R.layout.frag1;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {

        mXrv = (XRecyclerView) view.findViewById(R.id.xrv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mXrv.setLayoutManager(linearLayoutManager);
        mPresenter.Mobile("71e58b5b2f930eaf1f937407acde08fe","10",page+"");
        mXrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //刷新
                flag=true;
                page=1;
                mPresenter.Mobile("71e58b5b2f930eaf1f937407acde08fe","10",page+"");
            }

            @Override
            public void onLoadMore() {
                //加载更多
                flag=false;
                page++;
                mPresenter.Mobile("71e58b5b2f930eaf1f937407acde08fe","10",page+"");


            }
        });
    }

    @Override
    public void MobileSuccess(MobileBean mobileBean) {

        List<MobileBean.NewslistBean> newslist = mobileBean.getNewslist();
        ArrayList<MobileBean.NewslistBean> templist = new ArrayList<>();
        templist.addAll(newslist);

        if (flag){
            xrvAdapter = new XRVAdapter(getContext(), newslist);
            mXrv.setAdapter(xrvAdapter);
            xrvAdapter.shuxin(templist);
            mXrv.refreshComplete();//设置刷新完成

        }else {
            if (xrvAdapter!=null){
                xrvAdapter.jiazai(templist);
                mXrv.loadMoreComplete();
            }
        }
        if (xrvAdapter==null){
            return;
        }

    }
}

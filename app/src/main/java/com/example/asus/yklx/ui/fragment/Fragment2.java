package com.example.asus.yklx.ui.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.asus.yklx.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.net.URL;

/**
 * Created by asus on 2018/5/28.
 */

public class Fragment2 extends Fragment implements View.OnClickListener {
    private View view;
    /**
     * 加载图片
     */
    private Button mBtn;
    private ImageView mSim;
    private String url="http://img.taopic.com/uploads/allimg/140729/240450-140HZP45790.jpg";
    private boolean flag= true;
    private ImageCacheUtil imageCacheUtil;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag2, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        mBtn = (Button) view.findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
        mSim = (ImageView) view.findViewById(R.id.sim);
        imageCacheUtil =new ImageCacheUtil(getContext());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn:
                    imageCacheUtil.loadPic("http://imgwx3.2345.com/dypcimg/star/img/d/0/40/photo_192x262.jpg?1504084016",mSim);
                break;
        }
    }

}

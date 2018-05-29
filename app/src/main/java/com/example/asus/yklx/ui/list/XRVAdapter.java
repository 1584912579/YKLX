package com.example.asus.yklx.ui.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.yklx.R;
import com.example.asus.yklx.bean.MobileBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by asus on 2018/5/28.
 */

public class XRVAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<MobileBean.NewslistBean> list;
    private LayoutInflater inflater;

    public XRVAdapter(Context context, List<MobileBean.NewslistBean> list) {
        this.context = context;
        this.list = list;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 =(ViewHolder) holder;
        MobileBean.NewslistBean newslistBean = list.get(position);
        holder1.img.setImageURI(newslistBean.getPicUrl());
        holder1.title.setText(newslistBean.getTitle());
         holder1.tv.setText(newslistBean.getDescription()+" "+newslistBean.getCtime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView img;
        private final TextView title;
        private final TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            tv = itemView.findViewById(R.id.tv);
        }
    }
    public void shuxin(List<MobileBean.NewslistBean> templist){
//        this.list.clear();
        this.list.addAll(templist);
        notifyDataSetChanged();

    }
    public void jiazai(List<MobileBean.NewslistBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }
}

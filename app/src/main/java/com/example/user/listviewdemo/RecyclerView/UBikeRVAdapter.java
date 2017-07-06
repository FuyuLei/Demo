package com.example.user.listviewdemo.RecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.listviewdemo.R;

import java.util.ArrayList;


/**
 * Created by user on 2017/06/29.
 */

public class UBikeRVAdapter extends RecyclerView.Adapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Station> list;

    public UBikeRVAdapter(Context context, ArrayList<Station> list) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_rv_ubike, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ViewHolder h = (ViewHolder) holder;
            final Station item = list.get(position);
            h.name.setText("名稱" + item.getName());
            h.area.setText("區域" + item.getArea());
            h.total.setText("總共" + item.getTotal());
            h.count.setText("剩餘" + item.getCount());
            h.data.setText("最後更新時間" + item.getData());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView area;
        TextView total;
        TextView count;
        TextView data;

        public ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.tv_rv_ubike_name);
            area = (TextView) v.findViewById(R.id.tv_rv_ubike_area);
            total = (TextView) v.findViewById(R.id.tv_rv_ubike_total);
            count = (TextView) v.findViewById(R.id.tv_rv_ubike_count);
            data = (TextView) v.findViewById(R.id.tv_rv_ubike_data);
        }
    }

}

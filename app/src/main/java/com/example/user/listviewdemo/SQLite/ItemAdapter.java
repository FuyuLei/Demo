package com.example.user.listviewdemo.SQLite;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.user.listviewdemo.R;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {

    Context context;
    ArrayList<Item> list;

    public ItemAdapter(Context context, ArrayList<Item> list) {
        this.list = list;
        this.context = context;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        ViewHolder tag;
        if (v == null) {
            v = LayoutInflater.from(context).inflate(R.layout.list_item_accounting, null);
            tag = new ViewHolder(v);
            v.setTag(tag);
        } else {
            tag = (ViewHolder) v.getTag();
        }
        final Item item = (Item) getItem(position);
        // set text
        tag.datetime.setText(String.valueOf(item.getDatetime()));
        tag.item.setText(item.getItem());
        tag.money.setText("$"+item.getMoney());
        return v;
    }

    private class ViewHolder {
        TextView datetime;
        TextView item;
        TextView money;


        ViewHolder(View v) {
            datetime = (TextView) v.findViewById(R.id.tv_list_item_date);
            item = (TextView) v.findViewById(R.id.tv_list_item_item);
            money = (TextView) v.findViewById(R.id.tv_list_item_money);
        }
    }
}


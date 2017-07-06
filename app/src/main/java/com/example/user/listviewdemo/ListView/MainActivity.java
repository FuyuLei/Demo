package com.example.user.listviewdemo.ListView;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.user.listviewdemo.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.lv_main);
        ArrayList<Person> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            p.setImage(R.mipmap.ic_launcher);
            p.setName("皓鈞");
            p.setContent("你好");
            list.add(p);
        }

        mListView.setAdapter(new MyAdapter(this, list));
    }

    private class MyAdapter extends BaseAdapter {
        Context context;
        ArrayList<Person> list;

        public MyAdapter(Context context, ArrayList<Person> list) {
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
                v = LayoutInflater.from(context).inflate(R.layout.adapter, null);
                tag = new ViewHolder(v);
                v.setTag(tag);
            } else {
                tag = (ViewHolder) v.getTag();
            }
            final Person item = (Person) getItem(position);
            // set text
            tag.name.setText(item.getName());
            tag.content.setText(item.getContent());
            tag.image.setImageResource(item.getImage());
            return v;
        }

        private class ViewHolder {

            TextView name;
            TextView content;
            ImageView image;

            ViewHolder(View v) {
                name = (TextView) v.findViewById(R.id.tv_adapter_name);
                content = (TextView) v.findViewById(R.id.tv_adapter_content);
                image = (ImageView) v.findViewById(R.id.iv_adapter);
            }
        }
    }
}

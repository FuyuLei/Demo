package com.example.user.listviewdemo.RecyclerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.listviewdemo.R;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Station> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Station s = new Station();
            s.setName("OUO");
            s.setArea("Area");
            s.setTotal(60);
            s.setCount(30);
            s.setData(2017 / 06 / 29);
            list.add(s);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new UBikeRVAdapter(this, list));
    }




}

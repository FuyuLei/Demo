package com.example.user.listviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.listviewdemo.ListView.MainActivity;
import com.example.user.listviewdemo.RecyclerView.RecyclerViewActivity;
import com.example.user.listviewdemo.SQLite.AccountingActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Button btn_lv = (Button) findViewById(R.id.btn_home_go_lv);
        Button btn_rv = (Button) findViewById(R.id.btn_home_go_rv);
        Button btn_sqlite = (Button) findViewById(R.id.btn_home_go_sqlite);

        btn_lv.setOnClickListener(this);
        btn_rv.setOnClickListener(this);
        btn_sqlite.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_home_go_lv:
                Intent intent = new Intent();
                intent.setClass(this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_home_go_rv:
                Intent intent_rv = new Intent();
                intent_rv.setClass(this, RecyclerViewActivity.class);
                startActivity(intent_rv);
                break;

            case R.id.btn_home_go_sqlite:
                Intent intent_sqlite = new Intent();
                intent_sqlite.setClass(this, AccountingActivity.class);
                startActivity(intent_sqlite);
                break;
        }
    }

}

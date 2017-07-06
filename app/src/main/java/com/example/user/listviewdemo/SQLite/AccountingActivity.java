package com.example.user.listviewdemo.SQLite;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.listviewdemo.R;

import java.util.ArrayList;

public class AccountingActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    public static final int ADD = 0;
    public static final int UPDATE = 1;
    private LinearLayout include;
    private ListView lv;
    private ItemDAO itemDAO;
    private ArrayList<Item> list;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounting);

        include = (LinearLayout) findViewById(R.id.include);
        lv = (ListView) include.findViewById(R.id.lv_accounting_list);
        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(this);

        itemDAO = new ItemDAO(this);

        list = new ArrayList<>();
        // 取得所有記事資料
        list.addAll(itemDAO.getAll());
        lv.setAdapter(new ItemAdapter(this, list));
        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(this, AddAccountingActivity.class);
        startActivityForResult(intent, ADD);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Item item = list.get(position);
        Toast.makeText(this, item.getItem(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setClass(this, UpdateAccountingActivity.class);
        intent.putExtra("Id", item.getId());
        startActivityForResult(intent, UPDATE);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case ADD:
                list.clear();
                list.addAll(itemDAO.getAll());
                ((ItemAdapter)lv.getAdapter()).notifyDataSetChanged();
                break;
            case UPDATE:
                list.clear();
                list.addAll(itemDAO.getAll());
                ((ItemAdapter)lv.getAdapter()).notifyDataSetChanged();
                break;
        }
    }
}

package com.example.user.listviewdemo.SQLite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.listviewdemo.R;

import java.util.ArrayList;

public class UpdateAccountingActivity extends AppCompatActivity implements View.OnClickListener {

    private Button update;
    private Button delete;
    private EditText edtDate;
    private EditText edtItem;
    private EditText edtMoney;
    private ArrayList<Item> list;
    private ItemDAO itemDAO;
    private Item it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_accounting_item);

        update = (Button) findViewById(R.id.btn_update_accounting_update);
        delete = (Button) findViewById(R.id.btn_update_accounting_delete);
        edtDate = (EditText) findViewById(R.id.edt_update_accounting_date);
        edtItem = (EditText) findViewById(R.id.edt_update_accounting_item);
        edtMoney = (EditText) findViewById(R.id.edt_update_accounting_money);

        update.setOnClickListener(this);
        delete.setOnClickListener(this);

        itemDAO = new ItemDAO(this);

        int id = getIntent().getIntExtra("Id", 0);
        it = itemDAO.get(id);

        String date = it.getDatetime();
        String item = it.getItem();
        int money = it.getMoney();

        edtDate.setText(date);
        edtItem.setText(item);
        edtMoney.setText("" + money);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_update_accounting_update:
                String date = edtDate.getText().toString();
                String item = edtItem.getText().toString();
                int money = Integer.parseInt(edtMoney.getText().toString());
                it.setDatetime(date);
                it.setItem(item);
                it.setMoney(money);
                if (itemDAO.update(it)) {
                    finish();
                    setResult(RESULT_OK);
                } else {
                    Toast.makeText(this, "修改錯誤", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_update_accounting_delete:
                if (itemDAO.delete(it.getId())) {
                    finish();
                    setResult(RESULT_OK);
                } else {
                    Toast.makeText(this, "刪除錯誤", Toast.LENGTH_SHORT).show();
                }
                break;

        }

    }
}

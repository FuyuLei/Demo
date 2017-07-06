package com.example.user.listviewdemo.SQLite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.listviewdemo.R;

import java.util.ArrayList;

public class AddAccountingActivity extends AppCompatActivity implements View.OnClickListener {

    private Button add;
    private EditText edtDate;
    private EditText edtItem;
    private EditText edtMoney;
    private ArrayList<Item> list;
    private ItemDAO itemDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_accounting_item);

        add = (Button) findViewById(R.id.btn_add_accounting_add);
        edtDate = (EditText) findViewById(R.id.edt_add_accounting_date);
        edtItem = (EditText) findViewById(R.id.edt_add_accounting_item);
        edtMoney = (EditText) findViewById(R.id.edt_add_accounting_money);

        add.setOnClickListener(this);

        itemDAO = new ItemDAO(this);

    }

    @Override
    public void onClick(View v) {
        String date = edtDate.getText().toString();
        String item = edtItem.getText().toString();
        int money = Integer.parseInt(edtMoney.getText().toString());
        Item it = new Item();
        it.setDatetime(date);
        it.setItem(item);
        it.setMoney(money);
        if (itemDAO.insert(it)) {
            finish();
            setResult(RESULT_OK);
        }

    }
}

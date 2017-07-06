package com.example.user.listviewdemo.SQLite;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.listviewdemo.R;

import java.util.ArrayList;
import java.util.Calendar;

public class AddAccountingActivity extends AppCompatActivity implements View.OnClickListener {

    private Button add;
    private EditText edtDate;
    private EditText edtItem;
    private EditText edtMoney;
    private ArrayList<Item> list;
    private ItemDAO itemDAO;
    private int mYear, mMonth, mDay;

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

        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                new DatePickerDialog(AddAccountingActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        String format = setDateFormat(year, month, day);
                        edtDate.setText(format);
                    }

                }, mYear, mMonth, mDay).show();
            }

        });
    }

    private String setDateFormat(int year, int monthOfYear, int dayOfMonth) {
        String month;
        String day;

        if ((monthOfYear + 1) < 10) {
            month ="0" + (monthOfYear + 1);
        } else {
            month = String.valueOf(monthOfYear + 1);
        }

        if((dayOfMonth <10)){
            day = "0"+dayOfMonth;
        }else{
            day = String.valueOf(dayOfMonth);
        }

        return String.valueOf(year) + "-"
                + month + "-"
                + day;
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

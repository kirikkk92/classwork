package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.myapp.Utils.Dialog;
import com.example.myapp.adapter.FinancesAdapter;
import com.example.myapp.api.APIBuilder;
import com.example.myapp.model.Finance;
import com.example.myapp.model.FinanceResponse;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

public class FinanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance);

        ImageButton calendarBtn = findViewById(R.id.calendarBtn);
        calendarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog.showCalendarDialog(FinanceActivity.this, new Dialog.onDateChangeListener() {
                    @Override
                    public void onDateChange(int year, int month, int day) {
                        fetchFinances(year,month,day);
                    }
                });

            }
        });

        FloatingActionButton addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinanceActivity.this, AddCreditActivity.class);
                startActivity(intent);
            }
        });

        financesList = findViewById(R.id.financesList);
        FinancesAdapter adapter = new FinancesAdapter(fakeFinances, this);
        financesList.setAdapter(adapter);

        //TODO:uncomment
        Calendar calendar = Calendar.getInstance();
        fetchFinances(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
    }

    /////
    //TODO: remove
    private Finance[] fakeFinances = {
            new Finance(125.14f, "Вова", "Магазин", "24.03.2020"),
            new Finance(15.836f, "Федя", "Машина", "17.05.2019"),
            new Finance(95414.15f, "Вася", "Квартира", "15.02.2020"),
            new Finance(1.25f, "Коля", "Развлечения", "13.03.2020"),
    };
    /////

    private ListView financesList;

    public void fetchFinances(int year,int month,int day){
        APIBuilder<String, FinanceResponse>  builder = new APIBuilder<>();
        builder.execute("getFinance", String.format("%d/%d/%d", day, month, year), FinanceResponse.class, new APIBuilder.onCallback<FinanceResponse>() {
            @Override
            public void onResponce(FinanceResponse r) {
                if (!r.result){
                    Dialog.showErrorDialog(FinanceActivity.this,r.error);
                    return;
                }
                showList(r.finances);
            }

            @Override
            public void onError(Exception e) {
                Dialog.showErrorDialog(FinanceActivity.this,"За указанную дату ничего не найдено");
            }
        });
    }

    public void showList(Finance[] finances){
        FinancesAdapter adapter = new FinancesAdapter(finances,FinanceActivity.this);
        this.financesList.setAdapter(adapter);
        //notifyAll - насильно перерисует область с ListViev на экране
        this.financesList.notifyAll();
    }



}

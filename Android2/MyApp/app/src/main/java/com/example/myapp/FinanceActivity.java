package com.example.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.lesson2.adapter.FinanceAdapter;
import com.example.lesson2.model.Finance;
import com.example.lesson2.utils.Dialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FinanceActivity extends AppCompatActivity {
    /////TODO:remove
    private Finance[] fakeFinances = {
            new Finance(12.5f,"Kirill","shopping","24.03.2020 18:44:59"),
            new Finance(20f,"Vasya","shopping","02.07.2020 08:44:59"),
            new Finance(7f,"Olya","shopping","31.12.2020 12:44:59"),
            new Finance(5f,"Valya","shopping","01.01.2021 00:00:01"),
    };
    /////
    private ListView financesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance);
        ImageButton calendarBtn = findViewById(R.id.calendarBtn);
        calendarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog.showCalendarDialog(FinanceActivity.this);
            }
        });
        financesList = findViewById(R.id.financesList);
        FinanceAdapter adapter = new FinanceAdapter(this,fakeFinances);
        financesList.setAdapter(adapter);

        FloatingActionButton addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FinanceActivity.this,AddCreditActivity.class);
                startActivity(i);
            }
        });

    }
}


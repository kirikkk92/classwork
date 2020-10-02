package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.myapplication.api.APIBuilder;
import com.example.myapplication.model.AddFinanceRequest;
import com.example.myapplication.model.AddFinanceResponce;
import com.example.myapplication.model.CreditLabels;
import com.example.myapplication.utils.Dialog;

import java.util.Calendar;

public class AddCreditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_credit);
        Spinner credits = findViewById(R.id.credits);
        final EditText creditLabel = findViewById(R.id.creditLabel);
        final EditText sum = findViewById(R.id.sum);
        final EditText date = findViewById(R.id.date);
        final EditText time = findViewById(R.id.time);
        Button okBtr = findViewById(R.id.okBtn);
        String data[] = new String[CreditLabels.values().length];
        int i = 0;
        for (CreditLabels label : CreditLabels.values()) {
            data[i++] = label.get_label();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, data);
        credits.setAdapter(adapter);
        credits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CreditLabels label = CreditLabels.values()[position];
                if (label == CreditLabels.OTHER) {
                    creditLabel.setEnabled(true);
                    creditLabel.setText("");
                } else {
                    creditLabel.setEnabled(false);
                    creditLabel.setText(label.get_label());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Calendar calendar = Calendar.getInstance();
        String dateStr = String.format("%d/%d/%d",calendar.get(Calendar.DAY_OF_MONTH),calendar.get(calendar.MONTH)+1,calendar.get(calendar.YEAR));
        date.setText(dateStr);
        String timeStr = String.format("%d:%d:%d",calendar.get(calendar.HOUR_OF_DAY),calendar.get(calendar.MINUTE),calendar.get(calendar.SECOND));
        time.setText(timeStr);
        okBtr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(creditLabel.getText().toString().equals("")){
                    Dialog.showErrorDialog(AddCreditActivity.this,"Укажите статью затрат!");
                    return;
                }
                if(sum.getText().toString().equals("")){
                    Dialog.showErrorDialog(AddCreditActivity.this,"Укажите сумму затрат!");
                    return;
                }
                if(date.getText().toString().equals("")){
                    Dialog.showErrorDialog(AddCreditActivity.this,"Укажите дату!");
                    return;
                }
                if(time.getText().toString().equals("")){
                    Dialog.showErrorDialog(AddCreditActivity.this,"Укажите время!");
                    return;
                }
                AddFinanceRequest request = new AddFinanceRequest();
                request.creditLabel = creditLabel.getText().toString();
                request.date = date.getText().toString() + " " + time.getText().toString();
                try {
                    request.sum = Float.valueOf(sum.getText().toString());
                }catch (Exception e){
                    Dialog.showErrorDialog(AddCreditActivity.this,e.getMessage());
                    return;
                }
                addCredit(request);
            }
        });
    }
    public void addCredit(AddFinanceRequest req){
        APIBuilder<AddFinanceRequest,AddFinanceResponce> builder = new APIBuilder<>();
        builder.execute("addFinance", req, AddFinanceResponce.class, new APIBuilder.onCallback<AddFinanceResponce>() {
            @Override
            public void onResponse(AddFinanceResponce r) {
                if (!r.result){
                    Dialog.showErrorDialog(AddCreditActivity.this,r.error);
                    return;
                }
                onBackPressed();
            }

            @Override
            public void onError(Exception e) {
                Dialog.showErrorDialog(AddCreditActivity.this,e.getMessage());
            }
        });
    }
}

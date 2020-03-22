package com.example.lesson2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lesson2.API.APIBuilder;
import com.example.lesson2.model.ConfirmRequest;
import com.example.lesson2.model.ConfirmResponse;


public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        final EditText code = findViewById(R.id.code);
        Button confirmBtn = findViewById(R.id.confirmBtm);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( code.getText().toString().equals("")){
                    showError("Введите код!");
                    return;
                }
                confirmCode(code.getText().toString());
            }
        });
    }
    public void showError(String error){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);//вывод диалогового окна с ошибкой
        alert.setMessage(error);
        alert.setTitle("Ошибка");
        alert.setCancelable(true);
        alert.setPositiveButton("ЯСНО", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {}//вызов окна про нажатии на кнопку "ЯСНО
        });
        alert.setIcon(R.drawable.ic_launcher_background);//вывод иконки
        alert.create();//создает объект alert dialog
        alert.show();
    }
    public void confirmCode(String code){
        //запрос на сервер
        ConfirmRequest r = new ConfirmRequest();
        r.code = code;
        APIBuilder<ConfirmRequest,ConfirmResponse> builder = new APIBuilder<>();
        builder.execute("confirm", r, ConfirmResponse.class, new APIBuilder.onCallback<ConfirmResponse>() {
            @Override
            public void onResponse(ConfirmResponse resp) {
                if (!resp.result) {
                    showError(resp.error);
                }else {
                    showMenuActivity();
                }
            }
            @Override
            public void onError(Exception e) {
                showError(e.getMessage());
            }
        });
    }
    public void showMenuActivity(){
        Intent i = new Intent(this,MenuActivity.class);
        startActivity(i);
    }
}

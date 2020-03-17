package com.example.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lesson2.API.APIBuilder;
import com.example.lesson2.model.JoinRequest;
import com.example.lesson2.model.JoinResponse;
import com.example.lesson2.utils.Dialog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Join2Activity extends AppCompatActivity {

    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join2);
        email = findViewById(R.id.email);  //вытаскиваем id поля
        Button joinBtn = findViewById(R.id.joinBtn);//вытаскиваем id кнопки
        joinBtn.setOnClickListener(new View.OnClickListener() {    //добавляем слушателя для кнопки
            @Override
            public void onClick(View v) {
                //проверяем
                if(email.getText().toString().equals("")){
                    Dialog.showErrorDialog(Join2Activity.this,"Укажите email!!!");
                    return;
                }
                //проверка на правильный ввод email
                //регулярные выражения
                String regex = "^(.+)@(.+)$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(email.getText().toString());
                if(!matcher.matches()){
                    Dialog.showErrorDialog(Join2Activity.this,"Неверный email");
                    return;
                }
                //отправляем запрос на сервер
                join(email.getText().toString());
            }
        });
    }
    public  void  join(String email){ //реализация запроса на сервер
        JoinRequest r = new JoinRequest();//объект запроса
        r.email= email;

        APIBuilder<JoinRequest, JoinResponse> builder = new APIBuilder<>();
        builder.execute("join", r, JoinResponse.class, new APIBuilder.onCallback<JoinResponse>() {
            @Override
            public void onResponse(JoinResponse r) {
                Dialog.showDialog(Join2Activity.this,"Пароль отправлен на почту пользователя");
                Join2Activity.this.email.setText("");  //убираем все из поля email
            }

            @Override
            public void onError(Exception e) {
                Dialog.showErrorDialog(Join2Activity.this,e.getMessage());
            }
        });
    }
}

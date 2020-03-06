package com.example.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lesson2.API.APIService;
import com.example.lesson2.model.LoginRequest;
import com.example.lesson2.model.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText login = findViewById(R.id.login);
        final EditText password = findViewById(R.id.password);
        Button loginBtn = findViewById(R.id.loginBtn);
        final TextView errorMsg = findViewById(R.id.errorMsg);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String error = "";
                if (login.getText().toString().equals("")){
                    error = "Заполните поле \"Логин\"\n";
                }
                if (password.getText().toString().equals("")){
                    error += "Заполните поле \"Пароль\"\n";
                }
                if (!error.equals("")){
                    errorMsg.setText(error);
                    errorMsg.setVisibility(View.VISIBLE);
                    return;
                }
                loginUser(login.getText().toString(), password.getText().toString());
            }
        });

        TextView signubBtn = findViewById(R.id.signupBtn);
        signubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            showStartActivity();
            }
        });

        TextWatcher t = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                errorMsg.setText("");


            }

            @Override
            public void afterTextChanged(Editable s) { }
        };
        login.addTextChangedListener(t);
        password.addTextChangedListener(t);
        errorMsg.setVisibility(View.INVISIBLE);
    }
    public void showMenuActivity(){
        Intent i = new Intent(this,MenuActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//
        startActivity(i);
    }
    public void showStartActivity(){
        Intent i = new Intent(this,StartActivity.class);
        startActivity(i);
    }
    public void loginUser (String email, String password) {
        LoginRequest r = new LoginRequest();
        r.Email = email;
        r.Password = password;
        APIService
                .getInstance()
                .getAPI()
                .login(r)
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        LoginResponse resp = response.body();
                        if (!resp.result) {
                            //TODO: обработка ошибки
                        }else {
                            //TODO: сохранить токен в памяти устройства
                            showMenuActivity();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        //TODO: обработка ошибки
                    }
                });

    }
}

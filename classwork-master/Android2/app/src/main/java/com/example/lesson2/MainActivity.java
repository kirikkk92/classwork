package com.example.lesson2;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.preference.PreferenceManager;
        import android.text.Editable;
        import android.text.TextWatcher;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

        import com.example.lesson2.API.APIBuilder;
        import com.example.lesson2.model.LoginRequest;
        import com.example.lesson2.model.LoginResponse;


public class MainActivity extends AppCompatActivity {
    private TextView errorMsg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //проверяем выполнен ли вход
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);//влазим в кэш-память
        if(preferences.contains("API_TOKEN")){
            showMenuActivity();
            return;//завершаем выполнени данного метода
        }

        final EditText login = findViewById(R.id.login);
        final EditText password = findViewById(R.id.password);
        Button loginBtn = findViewById(R.id.loginBtn);
        errorMsg = findViewById(R.id.errorMsg);
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
    public void showError(String err){
        errorMsg.setVisibility(View.VISIBLE);
        errorMsg.setText(err);
    }

    public void loginUser (String email, String password) {
        LoginRequest r = new LoginRequest();
        r.Email = email;
        r.Password = password;
        APIBuilder<LoginRequest,LoginResponse> builder = new APIBuilder<>();
        builder.execute("login", r,LoginResponse.class,new APIBuilder.onCallback<LoginResponse>() {
            @Override
            public void onResponse(LoginResponse resp) {
                if (!resp.result) {
                    showError(resp.error);
                }else {
                    //сохранить токен в памяти устройства
                    //сохраняем токин в кэш приложения
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("API_TOKEN",resp.token);
                    editor.apply();
                    //получение объекта из кэша
                    //preferences.getString("API_TOKEN","default(значение по умолчанию)")
                    showMenuActivity();
                }
            }
            @Override
            public void onError(Exception e) {
                showError(e.getMessage());
            }
        });
    }
}

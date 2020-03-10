package com.example.lesson2.API;

import com.example.lesson2.model.LoginRequest;
import com.example.lesson2.model.LoginResponse;
import com.example.lesson2.model.RegistrationRequest;
import com.example.lesson2.model.RegistrationResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MyFamily {
    @POST("/login")
    Call<LoginResponse> login(@Body LoginRequest r);

    @POST("/registration")//создали вызов по адресу
    Call<RegistrationResponse> registration(@Body RegistrationRequest r);
}

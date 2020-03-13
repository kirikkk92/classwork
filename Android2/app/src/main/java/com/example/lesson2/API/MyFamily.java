package com.example.lesson2.API;

import com.example.lesson2.model.ConfirmRequest;
import com.example.lesson2.model.ConfirmResponse;
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

    @POST("/register")//создали вызов по адресу
    Call<RegistrationResponse> registration(@Body RegistrationRequest r);

    @POST("/submit")//создали вызов по адресу
    Call<ConfirmResponse> confirm(@Body ConfirmRequest r);
}

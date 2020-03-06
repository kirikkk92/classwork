package com.example.lesson2.API;

import com.example.lesson2.model.LoginRequest;
import com.example.lesson2.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface MyFamily {
    @GET("/login")
    Call<LoginResponse> login(@Body LoginRequest r);
}

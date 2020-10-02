package com.example.lesson2.API;

import com.example.lesson2.model.ConfirmRequest;
import com.example.lesson2.model.ConfirmResponse;
import com.example.lesson2.model.FinanceResponse;
import com.example.lesson2.model.JoinRequest;
import com.example.lesson2.model.JoinResponse;
import com.example.lesson2.model.LoginRequest;
import com.example.lesson2.model.LoginResponse;
import com.example.lesson2.model.RegistrationRequest;
import com.example.lesson2.model.RegistrationResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MyFamily {
    @POST("/login")
    Call<LoginResponse> login(@Body LoginRequest r);

    @POST("/register")//создали вызов по адресу
    Call<RegistrationResponse> registration(@Body RegistrationRequest r);

    @POST("/submit")//создали вызов по адресу
    Call<ConfirmResponse> confirm(@Body ConfirmRequest r);

    @POST("/join")//создали вызов по адресу
    Call<JoinResponse> join(@Body JoinRequest r);

    @GET("/finance")
    Call<FinanceResponse> getFinance(@Query("startAt")String start, @Query("endAt")String end);
    //Дополнительные параметры в запросе GET передаются в Query(та часть адреса расположенная после знака ?)
    //параметры задаются в виде key=value
    //между собой парамметры разделяются знаком &
    //server/finance?startAt=01-01-2020&endAt=02-02-2020
    //что бы задать Query-параметр в Retrofit необходимо использовать директиву @Query("key"),key- название параметра
    //Retrofit автоматически задаст параметру значение указанное в аргументе следующем за директивой

}

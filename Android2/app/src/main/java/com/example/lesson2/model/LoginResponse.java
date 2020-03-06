package com.example.lesson2.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("result")
    public boolean result;
    @SerializedName("error")
    public String error;
    @SerializedName("token")
    public  String token;// строка с зашифрованной информацией о вас
}

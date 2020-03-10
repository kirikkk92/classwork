package com.example.lesson2.model;

import com.google.gson.annotations.SerializedName;

// то что приходит с сервера
public class ConfirmResponse {
    @SerializedName("result")
    public boolean result;
    @SerializedName("error")
    public String error;
    @SerializedName("token")
    public String token;
}

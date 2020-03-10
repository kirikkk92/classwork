package com.example.lesson2.model;

import com.google.gson.annotations.SerializedName;

public class RegistrationResponse {
    @SerializedName("result")
    public boolean result;
    @SerializedName("error")
    public String error;

}

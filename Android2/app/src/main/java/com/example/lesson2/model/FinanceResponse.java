package com.example.lesson2.model;

import com.google.gson.annotations.SerializedName;

public class FinanceResponse {
    @SerializedName("result")
    public boolean result;
    @SerializedName("error")
    public String error;
    @SerializedName("finances")
    public Finance[] finances;
}

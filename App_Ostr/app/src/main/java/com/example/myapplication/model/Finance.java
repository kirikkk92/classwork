package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class Finance {
    @SerializedName("sum")
    public float sum;
    @SerializedName("name")
    public String name;
    @SerializedName("creditLabel")
    public String creditLabel;
    @SerializedName("date")
    public String date;

    public Finance(float sum, String name, String creditLabel, String date) {
        this.sum = sum;
        this.creditLabel = creditLabel;
        this.date = date;
        this.name = name;
    }
}

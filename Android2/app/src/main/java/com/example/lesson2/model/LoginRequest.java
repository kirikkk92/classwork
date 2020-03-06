package com.example.lesson2.model;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {
    @SerializedName("email")
    public String Email;
    @SerializedName("password")
    public String Password;

}

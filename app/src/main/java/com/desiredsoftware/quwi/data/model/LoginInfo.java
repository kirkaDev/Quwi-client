package com.desiredsoftware.quwi.data.model;

import com.google.gson.annotations.SerializedName;

public class LoginInfo {

    @SerializedName("email")
    String email;

    @SerializedName("password")
    String password;

    public LoginInfo(String email, String password)
    {
        this.email = email;
        this.password = password;
    }
}

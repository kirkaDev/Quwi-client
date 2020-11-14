package com.desiredsoftware.quwi.data.model.api.in.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthInfo {

    @SerializedName("token")
    @Expose
    private String token;

    @SerializedName("app_init")
    @Expose
    private AppInit appInit;

    @SerializedName("just_signup")
    @Expose
    private Boolean justSignup;

    public String getToken() {
        return token;
    }
}



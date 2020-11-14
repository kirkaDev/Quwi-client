package com.desiredsoftware.quwi.data.model.api.in.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserSettingsGlobal {

    @SerializedName("client_settings")
    @Expose
    private Object clientSettings;


}

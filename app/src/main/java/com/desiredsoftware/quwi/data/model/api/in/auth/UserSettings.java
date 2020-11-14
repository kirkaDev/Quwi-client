package com.desiredsoftware.quwi.data.model.api.in.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserSettings {

    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("mute_until_period")
    @Expose
    private Integer muteUntilPeriod;
    @SerializedName("is_mute_chats")
    @Expose
    private Boolean isMuteChats;
    @SerializedName("dta_mute_until")
    @Expose
    private Object dtaMuteUntil;
    @SerializedName("client_settings")
    @Expose
    private ClientSettings clientSettings;

}

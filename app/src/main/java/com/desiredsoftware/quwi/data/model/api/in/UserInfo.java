package com.desiredsoftware.quwi.data.model.api.in;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInfo {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("avatar_url")
    @Expose
    private Object avatarUrl;
    @SerializedName("is_online")
    @Expose
    private Integer isOnline;
    @SerializedName("dta_activity")
    @Expose
    private String dtaActivity;
    @SerializedName("dta_since")
    @Expose
    private Object dtaSince;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getAvatarUrl() {
        return avatarUrl;
    }

}


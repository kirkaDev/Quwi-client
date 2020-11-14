package com.desiredsoftware.quwi.data.model.api.in.projectlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class User {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("avatar_url")
    @Expose
    public Object avatarUrl;
    @SerializedName("is_online")
    @Expose
    public Integer isOnline;
    @SerializedName("dta_activity")
    @Expose
    public String dtaActivity;
    @SerializedName("dta_since")
    @Expose
    public Object dtaSince;

}

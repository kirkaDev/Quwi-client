package com.desiredsoftware.quwi.data.model.api.in.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IssuesFilter {
    @SerializedName("is_open")
    @Expose
    private Integer isOpen;
    @SerializedName("is_bug")
    @Expose
    private Object isBug;
}

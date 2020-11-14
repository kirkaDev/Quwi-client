package com.desiredsoftware.quwi.data.model.api.in.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClientSettings {
    @SerializedName("issues_filters")
    @Expose
    private List<IssuesFilter> issuesFilters = null;
    @SerializedName("hash")
    @Expose
    private String hash;
}

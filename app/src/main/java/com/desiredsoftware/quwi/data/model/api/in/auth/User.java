package com.desiredsoftware.quwi.data.model.api.in.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("id_company")
    @Expose
    private Integer idCompany;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("dta_create")
    @Expose
    private String dtaCreate;
    @SerializedName("avatar_url")
    @Expose
    private Object avatarUrl;
    @SerializedName("is_online")
    @Expose
    private Integer isOnline;
    @SerializedName("dta_activity")
    @Expose
    private String dtaActivity;
    @SerializedName("is_timer_online")
    @Expose
    private Integer isTimerOnline;
    @SerializedName("dta_timer_activity")
    @Expose
    private Object dtaTimerActivity;
    @SerializedName("timer_last")
    @Expose
    private Object timerLast;
    @SerializedName("is_active")
    @Expose
    private Boolean isActive;
    @SerializedName("timezone_offset")
    @Expose
    private Integer timezoneOffset;
    @SerializedName("due_penalties")
    @Expose
    private Integer duePenalties;
    @SerializedName("allow_timer_screens")
    @Expose
    private Boolean allowTimerScreens;
    @SerializedName("allow_timer_autostop")
    @Expose
    private Boolean allowTimerAutostop;
    @SerializedName("is_shared_from_me")
    @Expose
    private Boolean isSharedFromMe;
    @SerializedName("is_shared_for_me")
    @Expose
    private Boolean isSharedForMe;
    @SerializedName("projects")
    @Expose
    private List<Object> projects = null;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("email_signature")
    @Expose
    private Object emailSignature;

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

    public List<Object> getProjects() {
        return projects;
    }

    public void setProjects(List<Object> projects) {
        this.projects = projects;
    }
}

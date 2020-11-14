package com.desiredsoftware.quwi.data.model.api.in.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Company {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("logo_url")
    @Expose
    private Object logoUrl;
    @SerializedName("owner_fullname")
    @Expose
    private String ownerFullname;
    @SerializedName("dta_create")
    @Expose
    private String dtaCreate;
    @SerializedName("id_user")
    @Expose
    private Integer idUser;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("timezone_offset")
    @Expose
    private Integer timezoneOffset;
    @SerializedName("disc_space")
    @Expose
    private Integer discSpace;
    @SerializedName("tracked_timer_month")
    @Expose
    private Integer trackedTimerMonth;
    @SerializedName("screens_month")
    @Expose
    private Integer screensMonth;
    @SerializedName("screens_interval")
    @Expose
    private Integer screensInterval;
    @SerializedName("screens_quality")
    @Expose
    private Integer screensQuality;
    @SerializedName("screens_keep_days")
    @Expose
    private Integer screensKeepDays;
    @SerializedName("spent_sec_daily")
    @Expose
    private Integer spentSecDaily;
    @SerializedName("secret_word")
    @Expose
    private String secretWord;
    @SerializedName("updated")
    @Expose
    private Integer updated;
    @SerializedName("max_file_count")
    @Expose
    private Integer maxFileCount;
    @SerializedName("max_file_size")
    @Expose
    private Integer maxFileSize;
    @SerializedName("tariff")
    @Expose
    private Tariff tariff;

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
}

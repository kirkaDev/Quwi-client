package com.desiredsoftware.quwi.data.model.api.in.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tariff {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("sname")
    @Expose
    private String sname;
    @SerializedName("end_pay")
    @Expose
    private Object endPay;
    @SerializedName("is_free")
    @Expose
    private Boolean isFree;
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
    private String screensQuality;
    @SerializedName("is_chat")
    @Expose
    private Boolean isChat;
    @SerializedName("is_instant_screen")
    @Expose
    private Boolean isInstantScreen;
    @SerializedName("is_timelapse_video")
    @Expose
    private Boolean isTimelapseVideo;
    @SerializedName("is_member_area")
    @Expose
    private Boolean isMemberArea;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

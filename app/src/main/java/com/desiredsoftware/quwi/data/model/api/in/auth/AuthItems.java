package com.desiredsoftware.quwi.data.model.api.in.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthItems {
    @SerializedName("owner")
    @Expose
    private Boolean owner;
    @SerializedName("coder")
    @Expose
    private Boolean coder;
    @SerializedName("nub")
    @Expose
    private Boolean nub;
    @SerializedName("disc_space")
    @Expose
    private Boolean discSpace;
    @SerializedName("tracked_timer_month")
    @Expose
    private Boolean trackedTimerMonth;
    @SerializedName("screens_month")
    @Expose
    private Boolean screensMonth;
    @SerializedName("chat")
    @Expose
    private Boolean chat;
    @SerializedName("instant_screen")
    @Expose
    private Boolean instantScreen;
    @SerializedName("timelapse_video")
    @Expose
    private Boolean timelapseVideo;
    @SerializedName("member_area")
    @Expose
    private Boolean memberArea;

}

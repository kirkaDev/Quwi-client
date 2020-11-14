package com.desiredsoftware.quwi.data.model.api.in.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AppInit {

        @SerializedName("user")
        @Expose
        private User user;
        @SerializedName("user_settings_global")
        @Expose
        private UserSettingsGlobal userSettingsGlobal;
        @SerializedName("user_settings")
        @Expose
        private UserSettings userSettings;
        @SerializedName("user_ids")
        @Expose
        private List<Integer> userIds = null;
        @SerializedName("companies")
        @Expose
        private List<Company> companies = null;
        @SerializedName("auth_items")
        @Expose
        private AuthItems authItems;
        @SerializedName("chats_count_unread")
        @Expose
        private Integer chatsCountUnread;
        @SerializedName("id_channel_main")
        @Expose
        private Integer idChannelMain;
        @SerializedName("has_projects")
        @Expose
        private Boolean hasProjects;
        @SerializedName("has_own_company")
        @Expose
        private Boolean hasOwnCompany;
        @SerializedName("hidden_projects")
        @Expose
        private List<Object> hiddenProjects = null;

}

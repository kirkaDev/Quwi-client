package com.desiredsoftware.quwi.data.model.api.in.projectinfo;

import com.desiredsoftware.quwi.data.model.api.in.UserInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Project {

        @SerializedName("id")
        @Expose
        private Integer id;

        @SerializedName("name")
        @Expose
        private String name;

        @SerializedName("uid")
        @Expose
        private String uid;

        @SerializedName("logo_url")
        @Expose
        private Object logoUrl;

        @SerializedName("position")
        @Expose
        private Integer position;

        @SerializedName("is_active")
        @Expose
        private Integer isActive;

        @SerializedName("is_owner_watcher")
        @Expose
        private Integer isOwnerWatcher;

        @SerializedName("dta_user_since")
        @Expose
        private Object dtaUserSince;

        @SerializedName("users")
        @Expose
        private List<UserInfo> users = null;

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

        public List<UserInfo> getUsers() {
            return users;
        }
}

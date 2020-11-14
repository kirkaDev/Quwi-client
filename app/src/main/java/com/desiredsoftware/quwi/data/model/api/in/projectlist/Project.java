package com.desiredsoftware.quwi.data.model.api.in.projectlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Project {

@SerializedName("id")
@Expose
public Integer id;
@SerializedName("name")
@Expose
public String name;
@SerializedName("uid")
@Expose
public String uid;
@SerializedName("logo_url")
@Expose
public Object logoUrl;
@SerializedName("position")
@Expose
public Integer position;
@SerializedName("is_active")
@Expose
public Integer isActive;
@SerializedName("is_owner_watcher")
@Expose
public Integer isOwnerWatcher;
@SerializedName("dta_user_since")
@Expose
public Object dtaUserSince;
@SerializedName("users")
@Expose
public List<User> users = null;

    public Integer getIsActive() {
        return isActive;
    }

    public Object getLogoUrl() {
        return logoUrl;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id.intValue();
    }
}

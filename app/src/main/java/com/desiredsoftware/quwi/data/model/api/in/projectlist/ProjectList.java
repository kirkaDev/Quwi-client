package com.desiredsoftware.quwi.data.model.api.in.projectlist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProjectList {

    @SerializedName("projects")
    @Expose
    public List<Project> projects = null;

    public List<Project> getProjects() {
        return projects;
    }
}


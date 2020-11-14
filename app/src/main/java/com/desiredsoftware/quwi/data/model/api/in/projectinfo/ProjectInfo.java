package com.desiredsoftware.quwi.data.model.api.in.projectinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ProjectInfo {

    @SerializedName("project")
    @Expose
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}




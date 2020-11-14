package com.desiredsoftware.quwi.data.callback;

import com.desiredsoftware.quwi.data.model.api.in.ApiError;
import com.desiredsoftware.quwi.data.model.api.in.projectinfo.ProjectInfo;
import com.desiredsoftware.quwi.data.model.api.in.projectlist.ProjectList;

public interface ProjectListCallback {

    void onProjectsListLoaded(ProjectList projectsList);

    void onError(ApiError error);
}

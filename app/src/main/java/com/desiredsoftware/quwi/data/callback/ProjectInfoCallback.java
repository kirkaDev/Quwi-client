package com.desiredsoftware.quwi.data.callback;

import com.desiredsoftware.quwi.data.model.api.in.ApiError;
import com.desiredsoftware.quwi.data.model.api.in.projectinfo.ProjectInfo;

public interface ProjectInfoCallback {

    void onProjectInfoLoaded(ProjectInfo projectInfo);

    void onError(ApiError error);
}

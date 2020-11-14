package com.desiredsoftware.quwi.data.callback;

import com.desiredsoftware.quwi.data.model.api.in.ApiError;
import com.desiredsoftware.quwi.data.model.api.in.projectinfo.ProjectInfo;

public interface UpdateProjectCallback {

    void onProjectUpdated(ProjectInfo projectInfo);

    void onError(ApiError error);
}

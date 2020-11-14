package com.desiredsoftware.quwi.ui.projects;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.desiredsoftware.quwi.data.DataController;
import com.desiredsoftware.quwi.data.callback.AuthCallback;
import com.desiredsoftware.quwi.data.callback.ProjectInfoCallback;
import com.desiredsoftware.quwi.data.callback.UpdateProjectCallback;
import com.desiredsoftware.quwi.data.model.api.in.ApiError;
import com.desiredsoftware.quwi.data.model.api.in.auth.AuthInfo;
import com.desiredsoftware.quwi.data.model.api.in.projectinfo.Project;
import com.desiredsoftware.quwi.data.model.api.in.projectinfo.ProjectInfo;

import java.util.List;

public class ProjectDetailsViewModel extends ViewModel {

    private MutableLiveData<Project> liveProject;

    DataController dataController;

    Project projectInfo;
    String projectId;

    public ProjectDetailsViewModel() {
    dataController = new DataController();
    liveProject = new MutableLiveData<>();
}

     public void GetProjectInfo(String projectId)
    {
        dataController.ProjectInfo(projectId, new ProjectInfoCallback() {
            @Override
            public void onProjectInfoLoaded(ProjectInfo projectInfo) {
                setProjectInfo(projectInfo.getProject());
            }

            @Override
            public void onError(ApiError error) {
            }
        });
    }

    public void SetProjectName(String projectId, String newProjectName)
    {
        dataController.UpdateProject(projectId, newProjectName, new UpdateProjectCallback() {
            @Override
            public void onProjectUpdated(ProjectInfo projectInfo) {
            }

            @Override
            public void onError(ApiError error) {
            }
        });
    }

    public LiveData<Project> getLiveProjectList() {
        return this.liveProject;
    }

    private void setProjectInfo( Project projectInfo) {
        this.projectInfo = projectInfo;
        this.liveProject.setValue(projectInfo);
    }

     public void setProjectId(String projectId) {
        this.projectId = projectId;

         GetProjectInfo(projectId);
    }

    public String getProjectId() {
        return projectId;
    }
}
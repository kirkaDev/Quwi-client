package com.desiredsoftware.quwi.ui.projects;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.desiredsoftware.quwi.component.ProjectListAdapter;
import com.desiredsoftware.quwi.data.DataController;
import com.desiredsoftware.quwi.data.callback.AuthCallback;
import com.desiredsoftware.quwi.data.callback.ProjectInfoCallback;
import com.desiredsoftware.quwi.data.callback.ProjectListCallback;
import com.desiredsoftware.quwi.data.model.api.in.ApiError;
import com.desiredsoftware.quwi.data.model.api.in.projectinfo.ProjectInfo;
import com.desiredsoftware.quwi.data.model.api.in.auth.AuthInfo;
import com.desiredsoftware.quwi.data.model.api.in.projectlist.Project;
import com.desiredsoftware.quwi.data.model.api.in.projectlist.ProjectList;

import java.util.List;

public class ProjectsViewModel extends ViewModel {

    private MutableLiveData<List<Project>> liveProjectList;

    DataController dataController;

    List<Project> projectList;

    public ProjectsViewModel() {

        dataController = new DataController();

        GetProjectsList();

        liveProjectList = new MutableLiveData<>();
        liveProjectList.setValue(projectList);

    }
    public void GetProjectsList()
    {
        dataController.ProjectsList(new ProjectListCallback() {
            @Override
            public void onProjectsListLoaded(ProjectList projectsList) {
                setProjectList(projectsList);
                liveProjectList.setValue(projectList);
            }

            @Override
            public void onError(ApiError error) {

            }
        });
    }

    public LiveData<List<Project>> getProjectList() {
        GetProjectsList();
        return liveProjectList;
    }

    public void setProjectList(ProjectList projectList) {
        this.projectList = projectList.getProjects();
    }
}
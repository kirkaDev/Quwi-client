package com.desiredsoftware.quwi.data;

import com.desiredsoftware.quwi.api.service.ApiClient;
import com.desiredsoftware.quwi.data.callback.AuthCallback;
import com.desiredsoftware.quwi.data.callback.ProjectInfoCallback;
import com.desiredsoftware.quwi.data.callback.ProjectListCallback;
import com.desiredsoftware.quwi.data.callback.UpdateProjectCallback;
import com.desiredsoftware.quwi.data.model.LoginInfo;
import com.desiredsoftware.quwi.data.model.Utils;
import com.desiredsoftware.quwi.data.model.api.in.ApiError;
import com.desiredsoftware.quwi.data.model.api.in.projectinfo.ProjectInfo;
import com.desiredsoftware.quwi.data.model.api.in.auth.AuthInfo;
import com.desiredsoftware.quwi.data.model.api.in.projectlist.ProjectList;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataController {
    ApiClient server;

    public DataController() {
       this.server = new ApiClient();
    }

    public void Login(String email, String password, final AuthCallback callback) {
        server.getService().login(new LoginInfo(email, password)).enqueue(new Callback<AuthInfo>() {
                    @Override
                    public void onResponse(Call<AuthInfo> call, Response<AuthInfo> response) {
                        if (response.isSuccessful()) {
                            callback.Login(response.body());
                        } else {
                            callback.onError(server.getError(response));
                        }
                    }

                    @Override
                    public void onFailure(Call<AuthInfo> call, Throwable t) {
                        callback.onError(ApiError.fromException(call, t));
                    }
                });
    }

    public void ProjectInfo(String projectId, final ProjectInfoCallback callback){

        server.getService().getProjectInfo(projectId, Utils.getToken()).enqueue(new Callback<ProjectInfo>() {
            @Override
            public void onResponse(Call<ProjectInfo> call, Response<ProjectInfo> response) {
                if (response.isSuccessful()) {
                    callback.onProjectInfoLoaded(response.body());
                } else {
                    callback.onError(server.getError(response));
                }
            }

            @Override
            public void onFailure(Call<ProjectInfo> call, Throwable t) {
                callback.onError(ApiError.fromException(call, t));
            }
        });
    }

    public void ProjectsList(final ProjectListCallback callback){

        server.getService().getProjectsList(Utils.getToken()).enqueue(new Callback<ProjectList>() {
            @Override
            public void onResponse(Call<ProjectList> call, Response<ProjectList> response) {
                if (response.isSuccessful()) {
                    callback.onProjectsListLoaded(response.body());
                } else {
                    callback.onError(server.getError(response));
                }
            }

            @Override
            public void onFailure(Call<ProjectList> call, Throwable t) {
                callback.onError(ApiError.fromException(call, t));
            }
        });
    }

    public void UpdateProject(String projectId, String newProjectName, final UpdateProjectCallback callback){

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("name", newProjectName)
                .build();

        server.getService().updateProjectInfo(projectId, Utils.getToken(), requestBody).enqueue(new Callback<ProjectInfo>() {
            @Override
            public void onResponse(Call<ProjectInfo> call, Response<ProjectInfo> response) {
                if (response.isSuccessful()) {
                    callback.onProjectUpdated(response.body());
                } else {
                    callback.onError(server.getError(response));
                }
            }

            @Override
            public void onFailure(Call<ProjectInfo> call, Throwable t) {
                callback.onError(ApiError.fromException(call, t));
            }
        });
    }


}
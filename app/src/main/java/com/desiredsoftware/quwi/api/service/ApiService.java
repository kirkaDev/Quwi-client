package com.desiredsoftware.quwi.api.service;

import com.desiredsoftware.quwi.data.model.LoginInfo;
import com.desiredsoftware.quwi.data.model.api.in.projectinfo.ProjectInfo;
import com.desiredsoftware.quwi.data.model.api.in.auth.AuthInfo;
import com.desiredsoftware.quwi.data.model.api.in.projectlist.ProjectList;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("projects-manage/{projectId}")
    Call<ProjectInfo> getProjectInfo(@Path("projectId") String projectId, @Header("Authorization") String token);

    @GET("projects-manage/index")
    Call<ProjectList> getProjectsList(@Header("Authorization") String token);

    @POST("auth/login?=")
    Call<AuthInfo> login(@Body LoginInfo loginInfo);

    @POST("projects-manage/update?")
    Call<ProjectInfo> updateProjectInfo(@Query("id") String projectId, @Header("Authorization") String token, @Body RequestBody body);
}

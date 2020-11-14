package com.desiredsoftware.quwi.data.callback;

import com.desiredsoftware.quwi.data.model.api.in.ApiError;
import com.desiredsoftware.quwi.data.model.api.in.auth.AuthInfo;

public interface AuthCallback {

    void Login(AuthInfo authInfo);

    void onError(ApiError error);
}

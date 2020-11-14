package com.desiredsoftware.quwi.data.model;

import android.app.Activity;
import android.view.View;
import com.google.android.material.snackbar.Snackbar;

public class Utils {

    static String token;

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        Utils.token = "Bearer " + token;
    }

    public static void showSnackBar(Activity activity, String message) {
        View rootView = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        Snackbar.make(rootView, message, Snackbar.LENGTH_LONG).show();
    }

}

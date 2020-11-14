package com.desiredsoftware.quwi.ui.auth;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.desiredsoftware.quwi.MainActivity;
import com.desiredsoftware.quwi.R;
import com.desiredsoftware.quwi.data.DataController;
import com.desiredsoftware.quwi.data.callback.AuthCallback;
import com.desiredsoftware.quwi.data.model.Utils;
import com.desiredsoftware.quwi.data.model.api.in.ApiError;
import com.desiredsoftware.quwi.data.model.api.in.auth.AuthInfo;
import com.google.android.material.snackbar.Snackbar;

import static com.desiredsoftware.quwi.data.model.Utils.showSnackBar;

public class AuthFragment extends Fragment {

    private AuthViewModel mViewModel;

    EditText editTextEmail;
    EditText editTextTextPassword;
    Button buttonLogin;

    ConstraintLayout authLayout;

    public static AuthFragment newInstance() {
        return new AuthFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.auth_fragment, container, false);

        authLayout = root.findViewById(R.id.authLayout);
        editTextEmail = root.findViewById(R.id.editTextEmail);
        editTextTextPassword = root.findViewById(R.id.editTextTextPassword);
        buttonLogin = root.findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login(editTextEmail.getText().toString(),
                editTextTextPassword.getText().toString());
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AuthViewModel.class);
    }

    public void Login(String email, String password)
    {
        DataController dataController = new DataController();
        dataController.Login(email, password, new AuthCallback() {
            @Override
            public void Login(AuthInfo authInfo) {
                Utils.setToken(authInfo.getToken());

                if (Utils.getToken()!=null)
                {
                    ((MainActivity)getActivity()).runProjectListFragment();
                }
            }

            @Override
            public void onError(ApiError error) {
                Utils.showSnackBar(getActivity(), "Введены неверные данные");
            }
        });
    }


}
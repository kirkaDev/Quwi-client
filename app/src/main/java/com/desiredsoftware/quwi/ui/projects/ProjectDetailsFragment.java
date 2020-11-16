package com.desiredsoftware.quwi.ui.projects;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.desiredsoftware.quwi.R;
import com.desiredsoftware.quwi.component.usercomponent.UserAdapter;
import com.desiredsoftware.quwi.data.model.api.in.projectinfo.Project;

public class ProjectDetailsFragment extends Fragment {

    private ProjectDetailsViewModel projectExtendedInfoVM;

    EditText editTextProjectName;
    Button buttonOk;

    RecyclerView usersInfoRecyclerView;

    public static ProjectDetailsFragment newInstance() {
        return new ProjectDetailsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        projectExtendedInfoVM = new ViewModelProvider(this).get(ProjectDetailsViewModel.class);
        projectExtendedInfoVM.setProjectId(getArguments().getString("projectId"));

        View root = inflater.inflate(R.layout.project_details_fragment, container, false);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editTextProjectName = root.findViewById(R.id.editTextProjectName);
        buttonOk = root.findViewById(R.id.buttonOk);

        usersInfoRecyclerView = root.findViewById(R.id.recylerViewUsers);
        usersInfoRecyclerView.setLayoutManager(
                new GridLayoutManager(getActivity(), 2)
        );

        projectExtendedInfoVM.getLiveProjectList().observe(getViewLifecycleOwner(), new Observer<Project>() {
            @Override
            public void onChanged(@Nullable Project project) {
                if (project!=null)
                    Log.d("Listeners ", "called 'onChanged in ProjectExtendedInfo");
                editTextProjectName.setText(project.getName());
                usersInfoRecyclerView.setAdapter(new UserAdapter(project.getUsers()));
            }
        });

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                projectExtendedInfoVM.SetProjectName(projectExtendedInfoVM.getProjectId(), editTextProjectName.getText().toString());
            }
        });

        return root;

    }
}
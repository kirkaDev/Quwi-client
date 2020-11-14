package com.desiredsoftware.quwi.ui.projects;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.desiredsoftware.quwi.MainActivity;
import com.desiredsoftware.quwi.R;
import com.desiredsoftware.quwi.component.ProjectListAdapter;
import com.desiredsoftware.quwi.data.model.api.in.projectlist.Project;

import java.util.List;

public class ProjectsFragment extends Fragment {

    private ProjectsViewModel projectsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        projectsViewModel =
                new ViewModelProvider(this).get(ProjectsViewModel.class);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        final ListView listviewProjects = root.findViewById(R.id.listview_projects);

        projectsViewModel.getProjectList().observe(getViewLifecycleOwner(), new Observer<List<Project>>() {
            @Override
            public void onChanged(@Nullable List<Project> projectList) {

                if (projectList!=null)
                try{
                    listviewProjects.setAdapter(new ProjectListAdapter(getContext(), projectList));
                }
                catch (Exception e)
                {
                    e.getStackTrace();
                }
            }
        });

        listviewProjects.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {

                Project project = (Project)listviewProjects.getAdapter().getItem(position);

                Bundle bundle = new Bundle();
                bundle.putString("projectId", String.valueOf(project.getId()));

                ((MainActivity)getActivity()).runProjectExtendedInfoFragment(bundle);
            }
        });

        return root;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);


        OnBackPressedCallback callback = new OnBackPressedCallback(
                true
        ) {
            @Override
            public void handleOnBackPressed() {
                // Preventing transition to Login fragment
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }


}
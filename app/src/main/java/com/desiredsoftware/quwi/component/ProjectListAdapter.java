package com.desiredsoftware.quwi.component;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.desiredsoftware.quwi.R;
import com.desiredsoftware.quwi.data.model.api.in.projectlist.Project;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

import butterknife.ButterKnife;

public class ProjectListAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    List<Project> projects;

    public ProjectListAdapter(Context context, List<Project> projects) {
        this.context = context;
        this.projects = projects;
        this.inflater = (LayoutInflater) this.context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return projects.size();
    }

    @Override
    public Project getItem(int position) {
        return this.projects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.view_project_item, parent, false);
        }


        ImageView imgProjectIcon = ButterKnife.findById(view, R.id.imgViewProjectIcon);
        TextView txtViewProjectStatus = ButterKnife.findById(view, R.id.txtViewProjectStatus);
        TextView txtViewTimeForWeek = ButterKnife.findById(view, R.id.txtViewTimeForWeek);
        TextView txtViewTimeForMonth = ButterKnife.findById(view, R.id.txtViewTimeForMonth);
        TextView txtViewTotalTime = ButterKnife.findById(view, R.id.txtViewTotalTime);
        TextView txtViewProjectName = ButterKnife.findById(view, R.id.txtViewProjectName);

        Project project = getItem(position);

        try
        {
            Picasso.get().load(project.getLogoUrl().toString()).into(imgProjectIcon);
        }
        catch(NullPointerException e)
        {
            Log.e("Project logo URL error", e.getMessage());
        }

        txtViewProjectName.setText(project.getName().toString());
        txtViewProjectStatus.setText((project.getIsActive().intValue() == 1) ? "Active" : "Inactive");
        txtViewTimeForWeek.setText("04:23:46");
        txtViewTimeForMonth.setText("9:20:01");
        txtViewTotalTime.setText("25:10:00");

        return view;
    }
}

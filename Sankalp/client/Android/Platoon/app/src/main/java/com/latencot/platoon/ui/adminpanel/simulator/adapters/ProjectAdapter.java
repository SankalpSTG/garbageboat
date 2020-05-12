package com.latencot.platoon.ui.adminpanel.simulator.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.latencot.platoon.R;
import com.latencot.platoon.model.SharedItHelper;
import com.latencot.platoon.ui.adminpanel.simulator.SimulatorSelectProject;
import com.latencot.platoon.ui.profile.manageprojects.ProjectDetails;
import com.latencot.platoon.ui.profile.manageprojects.adapters.ProjectItems;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ViewHolder> {
    private ProjectItems projectItems[];
    private LayoutInflater mInflater;
    private ProjectAdapter.ItemClickListener mClickListener;
    Context context;

    // data is passed into the constructor
    public ProjectAdapter(Context context, ProjectItems projectItems[]) {
        this.mInflater = LayoutInflater.from(context);
        this.projectItems = projectItems;
        this.context = context;
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public ProjectAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.project_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull ProjectAdapter.ViewHolder holder, int position) {
        holder.tv_id.setText(projectItems[position].getSerial_id().toString());
        holder.tv_name.setText(projectItems[position].getProject_name().toString());
        holder.tv_description.setText(projectItems[position].getProject_description().toString());
        if(projectItems[position].getIs_anonymous() == 0) {
            holder.tv_isanonymous.setText("No");
        }else{
            holder.tv_isanonymous.setText("Yes");
        }
    }

    // total number of cells
    @Override
    public int getItemCount() {
        return projectItems.length;
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_id, tv_name, tv_description, tv_isanonymous;

        ViewHolder(View itemView) {
            super(itemView);
            tv_id = itemView.findViewById(R.id.pi_projectid);
            tv_name = itemView.findViewById(R.id.pi_projectname);
            tv_description = itemView.findViewById(R.id.pi_projectdescription);
            tv_isanonymous = itemView.findViewById(R.id.pi_projectisanonymous);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            ((SimulatorSelectProject)context).manageViewClickEvent(view);
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    ProjectItems getItem(int id) {
        return projectItems[id];
    }

    // allows clicks events to be caught
    void setClickListener(ProjectAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
package com.latencot.platoon.ui.userpanel.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.latencot.platoon.R;
import com.latencot.platoon.model.SharedItHelper;
import com.latencot.platoon.ui.userpanel.ProblemSolutions;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DeveloperAdapter extends RecyclerView.Adapter<DeveloperAdapter.ViewHolder>{
    private DeveloperItems developerItems[];
    private LayoutInflater mInflater;
    private DeveloperAdapter.ItemClickListener mClickListener;
    Context context;

    // data is passed into the constructor
    public DeveloperAdapter(Context context, DeveloperItems developerItems[]) {
        this.mInflater = LayoutInflater.from(context);
        this.developerItems = developerItems;
        this.context = context;
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public DeveloperAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.developer_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull DeveloperAdapter.ViewHolder holder, int position) {
        holder.tv_developername.setText(developerItems[position].getName().toString());
        holder.iv_developerimage.setImageDrawable(developerItems[position].getImage());
    }

    // total number of cells
    @Override
    public int getItemCount() {
        return developerItems.length;
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_developername;
        ImageView iv_developerimage;
        ViewHolder(View itemView) {
            super(itemView);
            tv_developername = itemView.findViewById(R.id.di_developername);
            iv_developerimage = itemView.findViewById(R.id.di_developerimage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    DeveloperItems getItem(int id) {
        return developerItems[id];
    }

    // allows clicks events to be caught
    void setClickListener(DeveloperAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}

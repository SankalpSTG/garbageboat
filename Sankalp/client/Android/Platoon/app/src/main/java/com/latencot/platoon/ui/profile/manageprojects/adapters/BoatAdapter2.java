package com.latencot.platoon.ui.profile.manageprojects.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.latencot.platoon.R;
import com.latencot.platoon.ui.profile.manageprojects.AddBoatToProject;

import java.math.BigInteger;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;

public class BoatAdapter2 extends RecyclerView.Adapter<BoatAdapter2.ViewHolder> {
    private BoatItems boatItems[];
    private LayoutInflater mInflater;
    private BoatAdapter2.ItemClickListener mClickListener;
    Context context;

    // data is passed into the constructor
    public BoatAdapter2(Context context, BoatItems boatItems[]) {
        this.mInflater = LayoutInflater.from(context);
        this.boatItems = boatItems;
        this.context = context;
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public BoatAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.boat_card_add, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull BoatAdapter2.ViewHolder holder, int position) {
        holder.tv_id.setText(boatItems[position].getId().toString());
        holder.tv_name.setText(boatItems[position].getName().toString());
        holder.tv_type.setText(boatItems[position].getType().toString());
        if(boatItems[position].getType().equals("master")) {
            holder.iv_boatimage.setImageResource(R.drawable.master_boat_image);
        }else{
            holder.iv_boatimage.setImageResource(R.drawable.slave_boat_image);
        }
    }

    // total number of cells
    @Override
    public int getItemCount() {
        return boatItems.length;
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_id, tv_name, tv_type;
        ImageView iv_boatimage;

        ViewHolder(View itemView) {
            super(itemView);
            tv_id = itemView.findViewById(R.id.bc_id);
            tv_name = itemView.findViewById(R.id.bc_name);
            tv_type = itemView.findViewById(R.id.bc_type);
            iv_boatimage = itemView.findViewById(R.id.bc_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            TextView tv_id = view.findViewById(R.id.bc_id);
            BigInteger regno = new BigInteger(tv_id.getText().toString());
            ((AddBoatToProject)context).addBoat(regno);
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    BoatItems getItem(int id) {
        return boatItems[id];
    }

    // allows clicks events to be caught
    void setClickListener(BoatAdapter2.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}

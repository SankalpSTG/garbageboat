package com.latencot.platoon.ui.profile.manageboats.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.latencot.platoon.R;
import com.latencot.platoon.model.SharedItHelper;
import com.latencot.platoon.ui.profile.manageboats.BoatDetails;
import com.latencot.platoon.ui.userpanel.ProblemSolutions;
import com.latencot.platoon.ui.userpanel.adapters.ProblemAdapter;
import com.latencot.platoon.ui.userpanel.adapters.ProblemItems;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BoatAdapter extends RecyclerView.Adapter<BoatAdapter.ViewHolder> {
    private BoatItems boatItems[];
    private LayoutInflater mInflater;
    private BoatAdapter.ItemClickListener mClickListener;
    Context context;

    // data is passed into the constructor
    public BoatAdapter(Context context, BoatItems boatItems[]) {
        this.mInflater = LayoutInflater.from(context);
        this.boatItems = boatItems;
        this.context = context;
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public BoatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.boat_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull BoatAdapter.ViewHolder holder, int position) {
        holder.tv_name.setText(boatItems[position].getSerial_id().toString());
        holder.tv_registrationno.setText(boatItems[position].getRegistration_number().toString());
        holder.tv_type.setText(boatItems[position].getType().toString());
        if(boatItems[position].getVerified() == 0) {
            holder.tv_verified.setText("To Be Verified");
        }else{
            holder.tv_verified.setText("Verified");
        }
        if (boatItems[position].getType().toString().equals("master")) {
            holder.iv_boatimage.setImageResource(R.drawable.master_boat_image);
        } else {
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
        TextView tv_name, tv_type, tv_registrationno, tv_verified;
        ImageView iv_boatimage;

        ViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.bi_petname);
            tv_registrationno = itemView.findViewById(R.id.bi_registrationno);
            tv_type = itemView.findViewById(R.id.bi_type);
            tv_verified = itemView.findViewById(R.id.bi_verified);
            iv_boatimage = itemView.findViewById(R.id.bi_boatimage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            TextView tv_boatregistrationno = view.findViewById(R.id.bi_registrationno);
            String registration_no = tv_boatregistrationno.getText().toString();
            Intent i = new Intent(context, BoatDetails.class);
            i.putExtra(SharedItHelper.registration_no, registration_no);
            context.startActivity(i);
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    BoatItems getItem(int id) {
        return boatItems[id];
    }

    // allows clicks events to be caught
    void setClickListener(BoatAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
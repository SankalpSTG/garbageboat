package com.latencot.platoon.ui.profile.manageprojects.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.latencot.platoon.R;
import com.latencot.platoon.model.SharedItHelper;
import com.latencot.platoon.ui.profile.manageboats.BoatDetails;
import com.latencot.platoon.ui.profile.manageprojects.ProjectDetails;

import org.w3c.dom.Text;

import java.math.BigInteger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
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
        View view = mInflater.inflate(R.layout.boat_card, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull BoatAdapter.ViewHolder holder, int position) {
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
        CardView cv_delete;

        ViewHolder(View itemView) {
            super(itemView);
            tv_id = itemView.findViewById(R.id.bc_id);
            tv_name = itemView.findViewById(R.id.bc_name);
            tv_type = itemView.findViewById(R.id.bc_type);
            iv_boatimage = itemView.findViewById(R.id.bc_image);
            cv_delete = itemView.findViewById(R.id.bc_delete);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            TextView tv_boatname = view.findViewById(R.id.bc_name);
            TextView tv_boatid = view.findViewById(R.id.bc_id);
            final BigInteger boatid = new BigInteger(tv_boatid.getText().toString());
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which){
                        case DialogInterface.BUTTON_POSITIVE:
                            ((ProjectDetails)context).deleteBoatFromProject(boatid);
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            break;
                    }
                }
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Delete " + tv_boatname.getText().toString() + "?")
                    .setPositiveButton("Yes", dialogClickListener)
                    .setNegativeButton("No", dialogClickListener)
                    .show();

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

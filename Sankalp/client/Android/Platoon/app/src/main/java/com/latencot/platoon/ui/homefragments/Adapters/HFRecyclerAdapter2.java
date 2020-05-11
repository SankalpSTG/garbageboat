package com.latencot.platoon.ui.homefragments.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.latencot.platoon.R;
import com.latencot.platoon.model.SharedIt;
import com.latencot.platoon.model.SharedItHelper;
import com.latencot.platoon.ui.adminpanel.simulator.SimulatorSelectProject;
import com.latencot.platoon.ui.authentication.LoginWithoutPassword;
import com.latencot.platoon.ui.userpanel.SubmitProblem;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HFRecyclerAdapter2 extends RecyclerView.Adapter<HFRecyclerAdapter2.ViewHolder> {

    private GridItems gridItems[];
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    Context context;
    SharedIt shr;

    // data is passed into the constructor
    public HFRecyclerAdapter2(Context context, GridItems gridItems[]) {
        this.mInflater = LayoutInflater.from(context);
        this.gridItems = gridItems;
        this.context = context;
        shr = new SharedIt(context);
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.gridcard2, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.myTextView.setText(gridItems[position].getTitle());
        holder.uselessimage.setImageDrawable(gridItems[position].getImagedrawable());
    }

    // total number of cells
    @Override
    public int getItemCount() {
        return gridItems.length;
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        ImageView uselessimage;
        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.info_text);
            uselessimage = itemView.findViewById(R.id.uselessimage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            TextView tv_infotext = view.findViewById(R.id.info_text);
            String info = tv_infotext.getText().toString();
            Intent i;
            if(shr.extractpreference(SharedItHelper.credential_id) == null) {
                i = new Intent(context, LoginWithoutPassword.class);
                context.startActivity(i);
            }
            switch (info){
                case "Simulator":
                    i = new Intent(context, SimulatorSelectProject.class);
                    context.startActivity(i);
                    break;
                case "Submit A Problem":
                    i = new Intent(context, SubmitProblem.class);
                    context.startActivity(i);
                    break;
            }
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    GridItems getItem(int id) {
        return gridItems[id];
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}